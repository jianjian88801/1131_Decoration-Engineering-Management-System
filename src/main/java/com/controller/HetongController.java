
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 合同管理
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/hetong")
public class HetongController {
    private static final Logger logger = LoggerFactory.getLogger(HetongController.class);

    @Autowired
    private HetongService hetongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LixiangxiangmuService lixiangxiangmuService;

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private KehuService kehuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("客户".equals(role))
            params.put("kehuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = hetongService.queryPage(params);

        //字典表数据转换
        List<HetongView> list =(List<HetongView>)page.getList();
        for(HetongView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HetongEntity hetong = hetongService.selectById(id);
        if(hetong !=null){
            //entity转view
            HetongView view = new HetongView();
            BeanUtils.copyProperties( hetong , view );//把实体数据重构到view中

                //级联表
                LixiangxiangmuEntity lixiangxiangmu = lixiangxiangmuService.selectById(hetong.getLixiangxiangmuId());
                if(lixiangxiangmu != null){
                    BeanUtils.copyProperties( lixiangxiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLixiangxiangmuId(lixiangxiangmu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HetongEntity hetong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hetong:{}",this.getClass().getName(),hetong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HetongEntity> queryWrapper = new EntityWrapper<HetongEntity>()
            .eq("lixiangxiangmu_id", hetong.getLixiangxiangmuId())
            .eq("hetong_name", hetong.getHetongName())
            .eq("hetong_text", hetong.getHetongText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HetongEntity hetongEntity = hetongService.selectOne(queryWrapper);
        if(hetongEntity==null){
            hetong.setInsertTime(new Date());
            hetong.setCreateTime(new Date());
            hetongService.insert(hetong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HetongEntity hetong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,hetong:{}",this.getClass().getName(),hetong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HetongEntity> queryWrapper = new EntityWrapper<HetongEntity>()
            .notIn("id",hetong.getId())
            .andNew()
            .eq("lixiangxiangmu_id", hetong.getLixiangxiangmuId())
            .eq("hetong_name", hetong.getHetongName())
            .eq("hetong_text", hetong.getHetongText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HetongEntity hetongEntity = hetongService.selectOne(queryWrapper);
        if("".equals(hetong.getHetongFile()) || "null".equals(hetong.getHetongFile())){
                hetong.setHetongFile(null);
        }
        if(hetongEntity==null){
            hetongService.updateById(hetong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        hetongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<HetongEntity> hetongList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HetongEntity hetongEntity = new HetongEntity();
//                            hetongEntity.setLixiangxiangmuId(Integer.valueOf(data.get(0)));   //立项项目 要改的
//                            hetongEntity.setHetongName(data.get(0));                    //合同标题 要改的
//                            hetongEntity.setHetongFile(data.get(0));                    //合同文件 要改的
//                            hetongEntity.setHetongText(data.get(0));                    //合同详情 要改的
//                            hetongEntity.setInsertTime(date);//时间
//                            hetongEntity.setCreateTime(date);//时间
                            hetongList.add(hetongEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        hetongService.insertBatch(hetongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
