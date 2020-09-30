package com.springboot.vuedemo.mapper;

import com.springboot.vuedemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//配置版
public interface UserXmlMapper {
    List<User> findAllUser();

    User findUserById(Integer id);

    void addUser(User user);

    void updateUserById(User user);

    void deleteUserById(Integer id);
}
