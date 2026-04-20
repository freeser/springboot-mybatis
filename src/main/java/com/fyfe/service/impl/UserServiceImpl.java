package com.fyfe.service.impl;

import com.fyfe.mapper.UserMapper;
import com.fyfe.pojo.User;
import com.fyfe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> login(String userName, String password) {
        return userMapper.login(userName,password);
    }

    @Override
    public List<User> checkUser(String userName) {
        return userMapper.checkUser(userName);
    }

    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }
}