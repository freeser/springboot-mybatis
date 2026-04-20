package com.fyfe.service;

import com.fyfe.pojo.User;

import java.util.List;

public interface UserService {
    List<User> login(String userName, String password);
    List<User> checkUser(String userName);

    int register(User user);
}
