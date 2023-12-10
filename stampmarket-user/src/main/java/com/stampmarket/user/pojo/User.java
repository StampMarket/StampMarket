package com.stampmarket.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // 用户id
    private Integer id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 用户余额，默认为0，单位为分
    private Integer balance;
}
