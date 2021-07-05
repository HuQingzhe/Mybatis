package com.ali.service.impl;

import com.ali.mapper.UserMapper;
import com.ali.model.User;
import com.ali.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author QingzheHu
 * @date 2021/7/2 17:42
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.selectOne(user);
    }
}
