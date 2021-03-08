package com.test.goods.dao;

import com.test.goods.pojo.User;

public interface UserMapper {

    int isLogin(User user);

    int add(User user);

    void updateUserImage(User user);
}
