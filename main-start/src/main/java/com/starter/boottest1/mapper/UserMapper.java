package com.starter.boottest1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.starter.boottest1.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 自定义方法
    User selectByName(String name);
}