package com.starter.boottest1.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.starter.boottest1.entity.User;
import com.starter.boottest1.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
@DS("primary") // 指定数据源
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    @Override
    public User getUserByName(String name) {
        return baseMapper.selectByName(name);
    }
}