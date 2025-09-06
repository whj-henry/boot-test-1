package com.starter.boottest1.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.starter.boottest1.entity.User;
import com.starter.boottest1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@DS("primary") // 类级别指定数据源
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> list() {
        return userService.list();
    }
    
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }
    
    @GetMapping("/name/{name}")
    public User getByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }
    
    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }
}