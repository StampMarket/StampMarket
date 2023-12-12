package com.stampmarket.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVO {
    private int id;
    private String username;
    private String token;
    private int balance;
}
