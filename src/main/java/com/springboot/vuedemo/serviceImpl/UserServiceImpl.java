package com.springboot.vuedemo.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.vuedemo.entity.User;
import com.springboot.vuedemo.mapper.UserMapper;
import com.springboot.vuedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**

 * @Author:wenzhimin

 * @Date: 2019/9/2

 * @Time: 15:23

 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser(){
        return userMapper.findAllUser();
    };

    @Override
    public User findUserById(int id){
        return userMapper.findUserById(id);
    };

    @Override
    public User findUserByName(String name){
        return userMapper.findUserByName(name);
    };

    @Override
    public void addUser(User user){
    };

    @Override
    public void updateUser(User user){

    };

    @Override
    public void deleteUserById(int id){

    };

    @Override
    public PageInfo<User> findAllUserByPage(int pageNum, int pageSize) {

        // TODO Auto-generated method stub

        PageHelper.startPage(pageNum, pageSize);

        List<User> lists = userMapper.findAllUser();

        PageInfo<User> pageInfo = new PageInfo<User>(lists);

        return pageInfo;
    }

}
