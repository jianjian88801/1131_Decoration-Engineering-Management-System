
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
 * 装修进度
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhuangxiujindu")
public class ZhuangxiujinduController {
    private static final Logger logger = LoggerFactory.getLogger(ZhuangxiujinduController.class);

    @Autowired
    private ZhuangxiujinduService zhuangxiujinduService;


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
        PageUtils page = zhuangxiujinduService.queryPage(params);

        //字典表数据转换
        List<ZhuangxiujinduView> list =(List<ZhuangxiujinduView>)page.getList();
        for(ZhuangxiujinduView c:list){
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
        ZhuangxiujinduEntity zhuangxiujindu = zhuangxiujinduService.selectById(id);
        if(zhuangxiujindu !=null){
            //entity转view
            ZhuangxiujinduView view = new ZhuangxiujinduView();
            BeanUtils.copyProperties( zhuangxiujindu , view );//把实体数据重构到view中

                //级联表
                LixiangxiangmuEntity lixiangxiangmu = lixiangxiangmuService.selectById(zhuangxiujindu.getLixiangxiangmuId());
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
    public R save(@RequestBody ZhuangxiujinduEntity zhuangxiujindu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhuangxiujindu:{}",this.getClass().getName(),zhuangxiujindu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhuangxiujinduEntity> queryWrapper = new EntityWrapper<ZhuangxiujinduEntity>()
            .eq("lixiangxiangmu_id", zhuangxiujindu.getLixiangxiangmuId())
            .eq("zhuangxiujindu_name", zhuangxiujindu.getZhuangxiujinduName())
            .eq("zhuangxiujindu_text", zhuangxiujindu.getZhuangxiujinduText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuangxiujinduEntity zhuangxiujinduEntity = zhuangxiujinduService.selectOne(queryWrapper);
        if(zhuangxiujinduEntity==null){
            zhuangxiujindu.setInsertTime(new Date());
            zhuangxiujindu.setCreateTime(new Date());
            zhuangxiujinduService.insert(zhuangxiujindu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhuangxiujinduEntity zhuangxiujindu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhuangxiujindu:{}",this.getClass().getName(),zhuangxiujindu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhuangxiujinduEntity> queryWrapper = new EntityWrapper<ZhuangxiujinduEntity>()
            .notIn("id",zhuangxiujindu.getId())
            .andNew()
            .eq("lixiangxiangmu_id", zhuangxiujindu.getLixiangxiangmuId())
            .eq("zhuangxiujindu_name", zhuangxiujindu.getZhuangxiujinduName())
            .eq("zhuangxiujindu_text", zhuangxiujindu.getZhuangxiujinduText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuangxiujinduEntity zhuangxiujinduEntity = zhuangxiujinduService.selectOne(queryWrapper);
        if("".equals(zhuangxiujindu.getZhuangxiujinduPhoto()) || "null".equals(zhuangxiujindu.getZhuangxiujinduPhoto())){
                zhuangxiujindu.setZhuangxiujinduPhoto(null);
        }
        if(zhuangxiujinduEntity==null){
            zhuangxiujinduService.updateById(zhuangxiujindu);//根据id更新
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
        zhuangxiujinduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhuangxiujinduEntity> zhuangxiujinduList = new ArrayList<>();//上传的东西
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
                            ZhuangxiujinduEntity zhuangxiujinduEntity = new ZhuangxiujinduEntity();
//                            zhuangxiujinduEntity.setLixiangxiangmuId(Integer.valueOf(data.get(0)));   //立项项目 要改的
//                            zhuangxiujinduEntity.setZhuangxiujinduName(data.get(0));                    //进度标题 要改的
//                            zhuangxiujinduEntity.setZhuangxiujinduPhoto("");//照片
//                            zhuangxiujinduEntity.setZhuangxiujinduText(data.get(0));                    //进度详情 要改的
//                            zhuangxiujinduEntity.setInsertTime(date);//时间
//                            zhuangxiujinduEntity.setCreateTime(date);//时间
                            zhuangxiujinduList.add(zhuangxiujinduEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhuangxiujinduService.insertBatch(zhuangxiujinduList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
