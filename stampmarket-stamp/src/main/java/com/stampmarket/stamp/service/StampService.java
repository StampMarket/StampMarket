package com.stampmarket.stamp.service;

import com.stampmarket.stamp.pojo.Stamp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StampService {
//    List<Stamp> listAllStamps();
    void addStamp(Stamp stamp);
    void deleteStamp(Integer id);
    List<Stamp> listAllStamp();
    void updateStampPrice(Integer id, Double price);
    Integer queryStampPrice(Integer id);
}
