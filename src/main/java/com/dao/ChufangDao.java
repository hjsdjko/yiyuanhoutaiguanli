package com.dao;

import com.entity.ChufangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChufangView;

/**
 * 处方 Dao 接口
 *
 * @author 
 */
public interface ChufangDao extends BaseMapper<ChufangEntity> {

   List<ChufangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
