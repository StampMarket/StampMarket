package com.stampmarket.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "stamp", fallback = StampControllerImpl.class)
public interface StampController {
    @RequestMapping(value = "/price/{id}", method = RequestMethod.GET)
    Integer getPriceForStampId(@PathVariable(value = "id") Integer id);
}
