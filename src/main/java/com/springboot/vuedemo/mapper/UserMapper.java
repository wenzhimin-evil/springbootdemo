package com.springboot.vuedemo.mapper;

import com.springboot.vuedemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//注解版
@Repository
public interface UserMapper{
    //    mybatis中数据库不能自动识别大写字母，如userName，它只认识user_name，因此需要转换
    @Select("SELECT * FROM sys_users")
    @Results({
            @Result(column = "username",property = "username")
    })
    List<User> findAllUser();

    @Insert("INSERT INTO sys_users(username,password) VALUES (#{username},#{password})")
    @Results({
            @Result(column = "username",property = "username")
    })
    void addUser(User user);

    @Update("UPDATE sys_users SET username=#{username},password=#{password} where id=#{id}")
    @Results({
            @Result(column = "username",property = "username")
    })
    void updateUser(User user);

    @Select("SELECT * FROM sys_users WHERE id=#{id}")
    User findUserById(int id);

    @Select("SELECT * FROM sys_users WHERE username=#{name}")
    User findUserByName(@Param("name") String name);

    @Delete("DELETE FROM sys_users WHERE id=#{id}")
    void deleteUserById(int id);
}
