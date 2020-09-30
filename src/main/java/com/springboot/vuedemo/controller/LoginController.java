package com.springboot.vuedemo.controller;


import com.springboot.vuedemo.api.CommonResult;
import com.springboot.vuedemo.entity.User;
import com.springboot.vuedemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录、登出、错误页面跳转控制器
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * shiro登录，shiro采用Facade模式（门面模式），所有与shiro的交互都通过Subject对象API。
     * 调用Subject.login后会触发UserRealm的doGetAuthenticationInfo方法，进行具体的登录验证处理。
     *
     * @param  user
     * @return
     */
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody User user) {


        System.out.print(user.getUsername());

        // 1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        // 2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());

        // 3.执行登录方法
        try{
            subject.login(token);

            //跳转首页
            return CommonResult.success(user.getUsername());
        } catch (UnknownAccountException e){
            e.printStackTrace();
            //用户名不存在！
            return CommonResult.validateFailed();
        } catch (IncorrectCredentialsException e){
            e.printStackTrace();
            //密码错误！
            return CommonResult.validateFailed();
        }

    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "addUser is ok! \n" + user;
    }

    /**
     * 添加角色
     * @param
     * @return
     */
    @PostMapping(value = "/addRole")
//    public String addRole(@RequestBody Role role) {
//        role = userService.addRole(role);
//        return "addRole is ok! \n" + role;
//    }

    /**
     * 注解的使用
     * @return
     */
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @GetMapping(value = "/create")
    public String create() {
        return "Create success!";
    }

    @GetMapping(value = "/index")
    public String index() {
        return "index page!";
    }

    @GetMapping(value = "/error")
    public String error() {
        return "error page!";
    }

    /**
     * 退出的时候是get请求，主要是用于退出
     * @return
     */
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        return "logout";
    }


}

