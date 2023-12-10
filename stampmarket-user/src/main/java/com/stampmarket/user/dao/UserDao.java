package com.stampmarket.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.stampmarket.user.pojo.User;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Insert("insert into user(username, password) values(#{username}, #{password})")
    void save(User user);

    @Select("select * from user where username = #{username}")
    User getByUsername(String username);
}
