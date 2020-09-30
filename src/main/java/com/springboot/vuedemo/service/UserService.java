package com.springboot.vuedemo.service;

import com.github.pagehelper.PageInfo;
import com.springboot.vuedemo.entity.User;
import com.springboot.vuedemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


/**

 * @Author:wenzhimin

 * @Date: 2019/9/2

 * @Time: 15:23

 */

public interface UserService {

    List<User> findAllUser();

    User findUserById(int id);

    User findUserByName(String name);

    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    PageInfo<User> findAllUserByPage(int pageNum, int pageSize);

}
