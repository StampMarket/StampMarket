package com.stampmarket.order.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StampControllerImpl implements StampController {
    @Override
    public Integer getPriceForStampId(Integer id) {
        log.info("Stamp service is not available");
        return Integer.MAX_VALUE;
    }
}
