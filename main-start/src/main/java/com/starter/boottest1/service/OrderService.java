package com.starter.boottest1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.starter.boottest1.entity.Order;

public interface OrderService extends IService<Order> {
    Order getOrderByNo(String orderNo);
}