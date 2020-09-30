package com.springboot.vuedemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.springboot.vuedemo.entity.User;
import com.springboot.vuedemo.mapper.UserMapper;
import com.springboot.vuedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableTransactionManagement
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/findAllUser")
    public JSONObject findAllUser(){
        List<User> userList = userService.findAllUser();
        JSONObject json =new JSONObject();
        json.put("data",userList);
        return json;
    }

    @RequestMapping("/addUser")
    public void addUser(User user){
        userService.addUser(user);
    }

    @RequestMapping("/updateUserById")
    public JSONObject updateUserById(User user){
        userService.updateUser(user);
        JSONObject json =new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/findUserById")
    public JSONObject findUserById(int id){
        User user = userService.findUserById(id);
        JSONObject json =new JSONObject();
        json.put("data",user);
        return json;
    }

    @RequestMapping("/deleteUserById")
    public void deleteUserById(int id){
        userService.deleteUserById(id);
    }


    @RequestMapping("/pageHelperAllUser")
    public PageInfo<User> pageHelperAllUser(){

        PageInfo<User> queryResult = userService.findAllUserByPage(1, 5);

        return queryResult;

    }

}
