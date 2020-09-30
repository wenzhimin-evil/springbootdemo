package com.springboot.vuedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
   权限对应实体类
 * @Author:evil

 * @Date: 2020/09/24

 * @Time: 21:40

 */
@Data
@AllArgsConstructor
public class Permissions {
    private int id;
    private String permission;
    private String description;
    private String rid;
    private String available;
}
