package com.starter.boottest1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.starter.boottest1.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    // 自定义方法
    Order selectByOrderNo(String orderNo);
}