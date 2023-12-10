package com.stampmarket.user.service.impl;

import com.stampmarket.common.utils.JwtTool;
import com.stampmarket.user.dao.UserDao;
import com.stampmarket.user.pojo.User;
import com.stampmarket.user.pojo.UserLoginDTO;
import com.stampmarket.user.pojo.UserLoginVO;
import com.stampmarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public void register(User user) {
        userDao.save(user);
    }

    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        User user = userDao.getByUsername(userLoginDTO.getUsername());
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        String token = JwtTool.getToken("stamp_market", 3600_000, claims);
        return new UserLoginVO(user.getId(), user.getUsername(), token, user.getBalance());
    }
}
