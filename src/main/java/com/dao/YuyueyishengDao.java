package com.dao;

import com.entity.YuyueyishengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyueyishengView;

/**
 * 预约医生 Dao 接口
 *
 * @author 
 */
public interface YuyueyishengDao extends BaseMapper<YuyueyishengEntity> {

   List<YuyueyishengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
