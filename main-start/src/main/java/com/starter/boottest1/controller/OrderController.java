package com.starter.boottest1.controller;

import com.baomidou.dynamic.datasource.annotation.DS;

import com.starter.boottest1.entity.Order;
import com.starter.boottest1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@DS("secondary") // 类级别指定数据源
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping
    public List<Order> list() {
        return orderService.list();
    }
    
    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getById(id);
    }
    
    @GetMapping("/no/{orderNo}")
    public Order getByOrderNo(@PathVariable String orderNo) {
        return orderService.getOrderByNo(orderNo);
    }
    
    @PostMapping
    public boolean save(@RequestBody Order order) {
        return orderService.save(order);
    }
}