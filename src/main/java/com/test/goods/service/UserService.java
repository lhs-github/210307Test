package com.test.goods.service;

import com.test.goods.pojo.User;

public interface UserService {

    boolean isLogin(User user);

    int add(User user);

    void updateUserImage(String fileName, String email);
}
