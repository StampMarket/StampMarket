package com.stampmarket.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.stampmarket.user.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao {
    @Insert("insert into user(username, password) values(#{username}, #{password})")
    void save(User user);

    @Select("select * from user where id = #{id}")
    User getById(Integer id);

    @Select("select * from user where username = #{username}")
    User getByUsername(String username);

    @Update("update user set balance = balance + #{amount} where id = #{id}")
    void updateBalance(Integer id, Integer amount);
}
