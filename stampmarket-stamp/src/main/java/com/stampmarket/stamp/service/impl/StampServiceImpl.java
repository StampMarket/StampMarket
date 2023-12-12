package com.stampmarket.stamp.service.impl;

import com.stampmarket.stamp.dao.StampDao;
import com.stampmarket.stamp.pojo.Stamp;
import com.stampmarket.stamp.service.StampService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StampServiceImpl implements StampService {
    private final StampDao stampDao;

    @Override
    public void addStamp(Stamp stamp) {
        stampDao.add(stamp);
    }

    @Override
    public void deleteStamp(Integer id) {
        stampDao.delete(id);
    }

    @Override
    public List<Stamp> listAllStamp() {
        return stampDao.listAllStamp();
    }

    @Override
    public void updateStampPrice(Integer id, Double price) {
        stampDao.updatePrice(id, price);
    }
}
