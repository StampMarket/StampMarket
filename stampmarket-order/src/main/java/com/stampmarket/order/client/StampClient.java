package com.stampmarket.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "stamp")
public interface StampClient {
    @RequestMapping(value = "/stamp/price/{id}", method = RequestMethod.GET)
    Integer getPriceForStampId(@PathVariable(value = "id") Integer id);
}
