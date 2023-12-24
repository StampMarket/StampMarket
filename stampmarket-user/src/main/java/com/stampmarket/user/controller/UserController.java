package com.stampmarket.user.controller;

import com.stampmarket.common.pojo.Result;
import com.stampmarket.user.pojo.User;
import com.stampmarket.user.pojo.UserLoginDTO;
import com.stampmarket.user.pojo.UserLoginVO;
import com.stampmarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public Result<Object> register(@RequestBody User user) {
        log.info("注册用户：{}", user);
        userService.register(user);
        return Result.success();
    }

    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);
        UserLoginVO userLoginVO = userService.login(userLoginDTO);
        return Result.success(userLoginVO);
    }

    @PutMapping("/recharge")
    public Result<Object> recharge(Integer id, Integer amount) {
        log.info("用户充值：id={}, amount={}", id, amount);
        userService.recharge(id, amount);
        return Result.success();
    }

    @PutMapping("/deduct")
    public Result<Object> deduct(Integer id, Integer amount, String password) {
        log.info("用户扣款：id={}, amount={}, password={}", id, amount, password);
        userService.deduct(id, amount, password);
        return Result.success();
    }
}
