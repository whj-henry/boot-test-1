package com.starter.boottest1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.starter.boottest1.entity.User;


public interface UserService extends IService<User> {
    User getUserByName(String name);
}