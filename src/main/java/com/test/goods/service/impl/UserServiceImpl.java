package com.test.goods.service.impl;

import com.test.goods.dao.UserMapper;
import com.test.goods.pojo.User;
import com.test.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public boolean isLogin(User user) {

        int result = userMapper.isLogin(user);
        System.out.println(result);

        return result > 0 ? true : false;
    }

    public int add(User user) {
        int result = userMapper.add(user);
        return result;
    }

    public void updateUserImage(String fileName, String email) {
        User user = new User();
        user.setImages(fileName);
        user.setEmail(email);
        userMapper.updateUserImage(user);
    }
}
