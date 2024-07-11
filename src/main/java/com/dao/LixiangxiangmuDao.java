package com.dao;

import com.entity.LixiangxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.LixiangxiangmuView;

/**
 * 立项项目 Dao 接口
 *
 * @author 
 */
public interface LixiangxiangmuDao extends BaseMapper<LixiangxiangmuEntity> {

   List<LixiangxiangmuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
