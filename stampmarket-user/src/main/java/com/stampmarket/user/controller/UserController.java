package com.stampmarket.user.controller;

import com.stampmarket.common.pojo.Result;
import com.stampmarket.user.pojo.User;
import com.stampmarket.user.pojo.UserLoginDTO;
import com.stampmarket.user.pojo.UserLoginVO;
import com.stampmarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public Result<Object> register(@RequestBody User user){
         log.info("注册用户：{}", user);
        userService.register(user);
        return Result.success();
    }

    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
         log.info("用户登录：{}", userLoginDTO);
        UserLoginVO userLoginVO = userService.login(userLoginDTO);
        return Result.success(userLoginVO);
    }
}
