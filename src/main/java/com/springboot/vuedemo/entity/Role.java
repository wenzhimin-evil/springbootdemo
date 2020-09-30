package com.springboot.vuedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
   角色对应实体类
 * @Author:evil

 * @Date: 2020/09/24

 * @Time: 21:40

 */
@Data
@AllArgsConstructor
public class Role {

    private int id;
    private String role;
    private String description;
    private String pid;
    private String available;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;
}
