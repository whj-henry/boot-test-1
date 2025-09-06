package com.starter.boottest1.controller;

import com.starter.boottest1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return userService.getById(1).getName();
    }
}
