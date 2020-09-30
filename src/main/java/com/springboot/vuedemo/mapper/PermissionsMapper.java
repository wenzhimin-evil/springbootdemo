package com.springboot.vuedemo.mapper;

import com.springboot.vuedemo.entity.Permissions;
import com.springboot.vuedemo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//注解版
@Repository
public interface PermissionsMapper {
    //    mybatis中数据库不能自动识别大写字母，如userName，它只认识user_name，因此需要转换
    @Select("SELECT * FROM sys_permissions")
    List<User> findAllPermissions();

    @Insert("INSERT INTO sys_permissions(permission,description,rid,available) VALUES (#{permission},#{description},#{rid},#{available})")
    void addPermissions(Permissions permissions);

    @Update("UPDATE sys_permissions SET permission=#{permission},description=#{description},rid=#{rid},available=#{available} where id=#{id}")
    void updatePermissions(Permissions permissions);

    @Select("SELECT * FROM sys_permissions WHERE id=#{id}")
    User findPermissionsById(int id);

    @Select("SELECT * FROM sys_permissions WHERE username=#{name} and password=#{pw}")
    User findPermissionsByPermissions(@Param("name") String name, @Param("pw") String pw);

    @Delete("DELETE FROM sys_permissions WHERE id=#{id}")
    void deletePermissionsById(int id);
}
