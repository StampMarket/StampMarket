package com.stampmarket.stamp.service;

import com.stampmarket.stamp.pojo.Stamp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StampService {
//    List<Stamp> listAllStamps();
    void addStamp(Stamp stamp);

    void deleteStamp(Integer id);
}
