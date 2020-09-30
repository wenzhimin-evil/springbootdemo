package com.springboot.vuedemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
   用户类
 * @Author:evil

 * @Date: 2020/09/24

 * @Time: 21:40

 */
@Data
@AllArgsConstructor
public class User implements Serializable {

    private int id;

    private String username;

    private String password;

    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;

}
