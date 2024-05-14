package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BingfangEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 病房 服务类
 */
public interface BingfangService extends IService<BingfangEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}