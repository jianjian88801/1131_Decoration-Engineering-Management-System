package com.dao;

import com.entity.ZhuangshicailiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuangshicailiaoView;

/**
 * 装饰材料总计划 Dao 接口
 *
 * @author 
 */
public interface ZhuangshicailiaoDao extends BaseMapper<ZhuangshicailiaoEntity> {

   List<ZhuangshicailiaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
