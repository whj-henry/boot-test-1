package com.starter.boottest1.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.starter.boottest1.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import com.starter.boottest1.entity.Order;

@Service
@DS("secondary") // 指定数据源
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    
    @Override
    public Order getOrderByNo(String orderNo) {
        return baseMapper.selectByOrderNo(orderNo);
    }
}