package com.stampmarket.stamp.dao;

import com.stampmarket.stamp.pojo.Stamp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StampDao {
    @Insert("insert into stamp( name, description, width, height, publish_date, price) values" +
            "(#{name}, #{description}, #{width}, #{height}, #{publishDate}, #{price})")
    void add(Stamp stamp);

    @Delete("delete from stamp where id = #{id}")
    void delete(Integer id);
}
