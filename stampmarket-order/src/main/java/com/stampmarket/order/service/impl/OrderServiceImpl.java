package com.stampmarket.order.service.impl;

import com.stampmarket.order.client.StampController;
import com.stampmarket.order.dao.OrderDao;
import com.stampmarket.order.pojo.OrderDTO;
import com.stampmarket.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final RestTemplate restTemplate;
    private final StampController stampController;

    @Override
    public void order(OrderDTO orderDetail) {
        Integer price = stampController.getPriceForStampId(orderDetail.getStampId());
        if (price == Integer.MAX_VALUE) {
            log.error("Stamp service is not available");
            throw new RuntimeException("Stamp service is not available");
        }

        restTemplate.put("http://user:9001/deduct?id={id}&amount={amount}&password={password}",
                null,
                orderDetail.getUserId(),
                orderDetail.getCount() * price,
                orderDetail.getPassword());
    }
}
