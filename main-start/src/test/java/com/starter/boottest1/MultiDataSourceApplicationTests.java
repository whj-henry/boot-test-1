package com.starter.boottest1;


import com.starter.boottest1.entity.Order;
import com.starter.boottest1.entity.User;
import com.starter.boottest1.mapper.OrderMapper;
import com.starter.boottest1.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class MultiDataSourceApplicationTests {
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private OrderMapper orderMapper;
    
    @Test
    void testPrimaryDataSource() {
        System.out.println("=== 测试主数据源 ===");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        assert users.size() > 0 : "主数据源查询失败";
    }
    
    @Test
    void testSecondaryDataSource() {
        System.out.println("=== 测试从数据源 ===");
        List<Order> orders = orderMapper.selectList(null);
        orders.forEach(System.out::println);
        assert orders.size() > 0 : "从数据源查询失败";
    }
    
    @Test
    void testCrossDataSourceOperation() {
        System.out.println("=== 测试跨数据源操作 ===");
        
        // 主数据源操作
        User user = new User();
        user.setName("测试用户");
        user.setAge(28);
        user.setEmail("test@example.com");
        userMapper.insert(user);
        System.out.println("插入用户成功，ID: " + user.getId());
        
        // 从数据源操作
        Order order = new Order();
        order.setOrderNo("TEST" + System.currentTimeMillis());
        order.setUserId(user.getId());
        order.setAmount(new BigDecimal(99.99));
        order.setStatus(1);
        orderMapper.insert(order);
        System.out.println("插入订单成功，ID: " + order.getId());
    }
}