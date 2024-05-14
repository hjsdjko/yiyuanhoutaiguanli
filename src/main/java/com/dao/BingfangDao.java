package com.dao;

import com.entity.BingfangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BingfangView;

/**
 * 病房 Dao 接口
 *
 * @author 
 */
public interface BingfangDao extends BaseMapper<BingfangEntity> {

   List<BingfangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
