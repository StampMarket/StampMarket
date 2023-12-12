package com.stampmarket.stamp.service;

import com.stampmarket.stamp.pojo.Stamp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StampService {
//    List<Stamp> listAllStamps();
    void addStamp(Stamp stamp);

    void deleteStamp(Integer id);
}
