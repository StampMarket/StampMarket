package com.stampmarket.user.service;

import com.stampmarket.user.pojo.User;
import com.stampmarket.user.pojo.UserLoginDTO;
import com.stampmarket.user.pojo.UserLoginVO;

public interface UserService {
    void register(User user);
    UserLoginVO login(UserLoginDTO userLoginDTO);
    void recharge(Integer userId, Integer amount);
    void deduct(Integer id, Integer amount, String password);
}
