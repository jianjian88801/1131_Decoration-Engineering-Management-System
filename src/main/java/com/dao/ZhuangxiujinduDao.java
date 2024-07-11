package com.dao;

import com.entity.ZhuangxiujinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuangxiujinduView;

/**
 * 装修进度 Dao 接口
 *
 * @author 
 */
public interface ZhuangxiujinduDao extends BaseMapper<ZhuangxiujinduEntity> {

   List<ZhuangxiujinduView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
