package com.stampmarket.stamp.dao;

import com.stampmarket.stamp.pojo.Stamp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StampDao {
    @Insert("insert into stamp( name, description, width, height, publish_date, price) values" +
            "(#{name}, #{description}, #{width}, #{height}, #{publishDate}, #{price})")
    void add(Stamp stamp);

    @Delete("delete from stamp where id = #{id}")
    void delete(Integer id);

    @Results(
            @Result(column = "publish_date", property = "publishDate")
    )
    @Select("select * from stamp")
    List<Stamp> listAllStamp();
}
