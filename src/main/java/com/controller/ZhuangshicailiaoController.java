
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
 * 装饰材料总计划
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhuangshicailiao")
public class ZhuangshicailiaoController {
    private static final Logger logger = LoggerFactory.getLogger(ZhuangshicailiaoController.class);

    @Autowired
    private ZhuangshicailiaoService zhuangshicailiaoService;


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
        PageUtils page = zhuangshicailiaoService.queryPage(params);

        //字典表数据转换
        List<ZhuangshicailiaoView> list =(List<ZhuangshicailiaoView>)page.getList();
        for(ZhuangshicailiaoView c:list){
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
        ZhuangshicailiaoEntity zhuangshicailiao = zhuangshicailiaoService.selectById(id);
        if(zhuangshicailiao !=null){
            //entity转view
            ZhuangshicailiaoView view = new ZhuangshicailiaoView();
            BeanUtils.copyProperties( zhuangshicailiao , view );//把实体数据重构到view中

                //级联表
                LixiangxiangmuEntity lixiangxiangmu = lixiangxiangmuService.selectById(zhuangshicailiao.getLixiangxiangmuId());
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
    public R save(@RequestBody ZhuangshicailiaoEntity zhuangshicailiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhuangshicailiao:{}",this.getClass().getName(),zhuangshicailiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhuangshicailiaoEntity> queryWrapper = new EntityWrapper<ZhuangshicailiaoEntity>()
            .eq("lixiangxiangmu_id", zhuangshicailiao.getLixiangxiangmuId())
            .eq("zhuangshicailiao_name", zhuangshicailiao.getZhuangshicailiaoName())
            .eq("zhuangshicailiao_types", zhuangshicailiao.getZhuangshicailiaoTypes())
            .eq("zhuangshicailiao_number", zhuangshicailiao.getZhuangshicailiaoNumber())
            .eq("zhuangshicailiao_danwei", zhuangshicailiao.getZhuangshicailiaoDanwei())
            .eq("zhuangshicailiao_text", zhuangshicailiao.getZhuangshicailiaoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuangshicailiaoEntity zhuangshicailiaoEntity = zhuangshicailiaoService.selectOne(queryWrapper);
        if(zhuangshicailiaoEntity==null){
            zhuangshicailiao.setInsertTime(new Date());
            zhuangshicailiao.setCreateTime(new Date());
            zhuangshicailiaoService.insert(zhuangshicailiao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhuangshicailiaoEntity zhuangshicailiao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhuangshicailiao:{}",this.getClass().getName(),zhuangshicailiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhuangshicailiaoEntity> queryWrapper = new EntityWrapper<ZhuangshicailiaoEntity>()
            .notIn("id",zhuangshicailiao.getId())
            .andNew()
            .eq("lixiangxiangmu_id", zhuangshicailiao.getLixiangxiangmuId())
            .eq("zhuangshicailiao_name", zhuangshicailiao.getZhuangshicailiaoName())
            .eq("zhuangshicailiao_types", zhuangshicailiao.getZhuangshicailiaoTypes())
            .eq("zhuangshicailiao_number", zhuangshicailiao.getZhuangshicailiaoNumber())
            .eq("zhuangshicailiao_danwei", zhuangshicailiao.getZhuangshicailiaoDanwei())
            .eq("zhuangshicailiao_text", zhuangshicailiao.getZhuangshicailiaoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuangshicailiaoEntity zhuangshicailiaoEntity = zhuangshicailiaoService.selectOne(queryWrapper);
        if("".equals(zhuangshicailiao.getZhuangshicailiaoPhoto()) || "null".equals(zhuangshicailiao.getZhuangshicailiaoPhoto())){
                zhuangshicailiao.setZhuangshicailiaoPhoto(null);
        }
        if(zhuangshicailiaoEntity==null){
            zhuangshicailiaoService.updateById(zhuangshicailiao);//根据id更新
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
        zhuangshicailiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhuangshicailiaoEntity> zhuangshicailiaoList = new ArrayList<>();//上传的东西
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
                            ZhuangshicailiaoEntity zhuangshicailiaoEntity = new ZhuangshicailiaoEntity();
//                            zhuangshicailiaoEntity.setLixiangxiangmuId(Integer.valueOf(data.get(0)));   //立项项目 要改的
//                            zhuangshicailiaoEntity.setZhuangshicailiaoName(data.get(0));                    //材料名称 要改的
//                            zhuangshicailiaoEntity.setZhuangshicailiaoPhoto("");//照片
//                            zhuangshicailiaoEntity.setZhuangshicailiaoMoney(data.get(0));                    //材料价格 要改的
//                            zhuangshicailiaoEntity.setZhuangshicailiaoTypes(Integer.valueOf(data.get(0)));   //材料类型 要改的
//                            zhuangshicailiaoEntity.setZhuangshicailiaoNumber(Integer.valueOf(data.get(0)));   //采购数量 要改的
//                            zhuangshicailiaoEntity.setZhuangshicailiaoDanwei(data.get(0));                    //单位 要改的
//                            zhuangshicailiaoEntity.setZhuangshicailiaoText(data.get(0));                    //材料详情 要改的
//                            zhuangshicailiaoEntity.setInsertTime(date);//时间
//                            zhuangshicailiaoEntity.setCreateTime(date);//时间
                            zhuangshicailiaoList.add(zhuangshicailiaoEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhuangshicailiaoService.insertBatch(zhuangshicailiaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
