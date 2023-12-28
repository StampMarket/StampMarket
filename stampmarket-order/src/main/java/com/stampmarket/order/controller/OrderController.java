package com.stampmarket.order.controller;

import com.stampmarket.common.pojo.Result;
import com.stampmarket.order.pojo.OrderDTO;
import com.stampmarket.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @PutMapping()
    public Result<Object> order(@RequestBody OrderDTO orderDTO) {
        log.info("Ordering with detail: " + orderDTO);
        orderService.order(orderDTO);
        return Result.success();
    }
}
