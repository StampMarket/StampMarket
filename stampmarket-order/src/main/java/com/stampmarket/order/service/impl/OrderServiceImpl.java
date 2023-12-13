package com.stampmarket.order.service.impl;

import com.stampmarket.order.dao.OrderDao;
import com.stampmarket.order.pojo.OrderDTO;
import com.stampmarket.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.stampmarket.common.pojo.Result;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final RestTemplate restTemplate;

    @Override
    public void order(OrderDTO orderDetail) {
        String url = "http://stamp:9002/price/" + orderDetail.getStampId();
        log.info("Getting StampPrice by: " + url);
        Integer price = restTemplate.getForObject(
                url,
                Integer.class);

        restTemplate.put("http://user:9001/deduct?id={id}&amount={amount}&password={password}",
                null,
                orderDetail.getUserId(),
                orderDetail.getCount(),
                orderDetail.getCount() * price,
                orderDetail.getPassword());
    }
}
