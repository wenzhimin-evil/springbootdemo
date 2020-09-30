package com.springboot.vuedemo.mapper;

import com.springboot.vuedemo.entity.Role;
import com.springboot.vuedemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//注解版
@Repository
public interface RoleMapper {
    //    mybatis中数据库不能自动识别大写字母，如userName，它只认识user_name，因此需要转换
    @Select("SELECT * FROM sys_roles")
    List<User> findAllRole();

    @Insert("INSERT INTO sys_roles(role,description,pid,available) VALUES (#{role},#{description},#{pid},#{available})")
    void addRole(Role role);

    @Update("UPDATE sys_roles SET role=#{role},description=#{description},pid=#{pid},available=#{available} where id=#{id}")
    void updateRole(User user);

    @Select("SELECT * FROM sys_roles WHERE id=#{id}")
    User findRoleById(int id);

    @Select("SELECT * FROM sys_roles WHERE username=#{name} and password=#{pw}")
    User findRoleByRole(@Param("name") String name, @Param("pw") String pw);

    @Delete("DELETE FROM sys_roles WHERE id=#{id}")
    void deleteRoleById(int id);
}
