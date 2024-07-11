
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
 * 立项项目
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/lixiangxiangmu")
public class LixiangxiangmuController {
    private static final Logger logger = LoggerFactory.getLogger(LixiangxiangmuController.class);

    @Autowired
    private LixiangxiangmuService lixiangxiangmuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private KehuService kehuService;
    @Autowired
    private YonghuService yonghuService;



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
        PageUtils page = lixiangxiangmuService.queryPage(params);

        //字典表数据转换
        List<LixiangxiangmuView> list =(List<LixiangxiangmuView>)page.getList();
        for(LixiangxiangmuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }


    /**
     * 后端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = lixiangxiangmuService.queryPage(params);

        //字典表数据转换
        List<LixiangxiangmuView> list =(List<LixiangxiangmuView>)page.getList();
        for(LixiangxiangmuView c:list){
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
        LixiangxiangmuEntity lixiangxiangmu = lixiangxiangmuService.selectById(id);
        if(lixiangxiangmu !=null){
            //entity转view
            LixiangxiangmuView view = new LixiangxiangmuView();
            BeanUtils.copyProperties( lixiangxiangmu , view );//把实体数据重构到view中

                //级联表
                KehuEntity kehu = kehuService.selectById(lixiangxiangmu.getKehuId());
                if(kehu != null){
                    BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKehuId(kehu.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(lixiangxiangmu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody LixiangxiangmuEntity lixiangxiangmu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,lixiangxiangmu:{}",this.getClass().getName(),lixiangxiangmu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            lixiangxiangmu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("客户".equals(role))
            lixiangxiangmu.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<LixiangxiangmuEntity> queryWrapper = new EntityWrapper<LixiangxiangmuEntity>()
            .eq("lixiangxiangmu_uuid_number", lixiangxiangmu.getLixiangxiangmuUuidNumber())
            .eq("lixiangxiangmu_name", lixiangxiangmu.getLixiangxiangmuName())
            .eq("yonghu_id", lixiangxiangmu.getYonghuId())
            .eq("kehu_id", lixiangxiangmu.getKehuId())
            .eq("lixiangxiangmu_types", lixiangxiangmu.getLixiangxiangmuTypes())
            .eq("lixiangxiangmu_yesno_types", lixiangxiangmu.getLixiangxiangmuYesnoTypes())
            .eq("lixiangxiangmu_yesno_text", lixiangxiangmu.getLixiangxiangmuYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LixiangxiangmuEntity lixiangxiangmuEntity = lixiangxiangmuService.selectOne(queryWrapper);
        if(lixiangxiangmuEntity==null){
            lixiangxiangmu.setLixiangxiangmuYesnoTypes(1);
            lixiangxiangmu.setCreateTime(new Date());
            lixiangxiangmuService.insert(lixiangxiangmu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LixiangxiangmuEntity lixiangxiangmu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,lixiangxiangmu:{}",this.getClass().getName(),lixiangxiangmu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            lixiangxiangmu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("客户".equals(role))
//            lixiangxiangmu.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LixiangxiangmuEntity> queryWrapper = new EntityWrapper<LixiangxiangmuEntity>()
            .notIn("id",lixiangxiangmu.getId())
            .andNew()
            .eq("lixiangxiangmu_uuid_number", lixiangxiangmu.getLixiangxiangmuUuidNumber())
            .eq("lixiangxiangmu_name", lixiangxiangmu.getLixiangxiangmuName())
            .eq("yonghu_id", lixiangxiangmu.getYonghuId())
            .eq("kehu_id", lixiangxiangmu.getKehuId())
            .eq("lixiangxiangmu_types", lixiangxiangmu.getLixiangxiangmuTypes())
            .eq("lixiangxiangmu_yesno_types", lixiangxiangmu.getLixiangxiangmuYesnoTypes())
            .eq("lixiangxiangmu_yesno_text", lixiangxiangmu.getLixiangxiangmuYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LixiangxiangmuEntity lixiangxiangmuEntity = lixiangxiangmuService.selectOne(queryWrapper);
        if("".equals(lixiangxiangmu.getLixiangxiangmuFile()) || "null".equals(lixiangxiangmu.getLixiangxiangmuFile())){
                lixiangxiangmu.setLixiangxiangmuFile(null);
        }
        if(lixiangxiangmuEntity==null){
            lixiangxiangmuService.updateById(lixiangxiangmu);//根据id更新
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
        lixiangxiangmuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<LixiangxiangmuEntity> lixiangxiangmuList = new ArrayList<>();//上传的东西
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
                            LixiangxiangmuEntity lixiangxiangmuEntity = new LixiangxiangmuEntity();
//                            lixiangxiangmuEntity.setLixiangxiangmuUuidNumber(data.get(0));                    //项目编号 要改的
//                            lixiangxiangmuEntity.setLixiangxiangmuName(data.get(0));                    //项目名称 要改的
//                            lixiangxiangmuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            lixiangxiangmuEntity.setKehuId(Integer.valueOf(data.get(0)));   //客户 要改的
//                            lixiangxiangmuEntity.setLixiangxiangmuTypes(Integer.valueOf(data.get(0)));   //项目类型 要改的
//                            lixiangxiangmuEntity.setLixiangxiangmuFile(data.get(0));                    //项目文件 要改的
//                            lixiangxiangmuEntity.setLixiangxiangmuYesnoTypes(Integer.valueOf(data.get(0)));   //审核结果 要改的
//                            lixiangxiangmuEntity.setLixiangxiangmuYesnoText(data.get(0));                    //审核原因 要改的
//                            lixiangxiangmuEntity.setCreateTime(date);//时间
                            lixiangxiangmuList.add(lixiangxiangmuEntity);


                            //把要查询是否重复的字段放入map中
                                //项目编号
                                if(seachFields.containsKey("lixiangxiangmuUuidNumber")){
                                    List<String> lixiangxiangmuUuidNumber = seachFields.get("lixiangxiangmuUuidNumber");
                                    lixiangxiangmuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> lixiangxiangmuUuidNumber = new ArrayList<>();
                                    lixiangxiangmuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("lixiangxiangmuUuidNumber",lixiangxiangmuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //项目编号
                        List<LixiangxiangmuEntity> lixiangxiangmuEntities_lixiangxiangmuUuidNumber = lixiangxiangmuService.selectList(new EntityWrapper<LixiangxiangmuEntity>().in("lixiangxiangmu_uuid_number", seachFields.get("lixiangxiangmuUuidNumber")));
                        if(lixiangxiangmuEntities_lixiangxiangmuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LixiangxiangmuEntity s:lixiangxiangmuEntities_lixiangxiangmuUuidNumber){
                                repeatFields.add(s.getLixiangxiangmuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [项目编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        lixiangxiangmuService.insertBatch(lixiangxiangmuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
