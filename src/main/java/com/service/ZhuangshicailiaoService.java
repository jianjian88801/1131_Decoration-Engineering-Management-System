package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuangshicailiaoEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 装饰材料总计划 服务类
 */
public interface ZhuangshicailiaoService extends IService<ZhuangshicailiaoEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}