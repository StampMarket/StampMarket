package com.stampmarket.stamp.controller;

import com.stampmarket.common.pojo.Result;
import com.stampmarket.stamp.pojo.Stamp;
import com.stampmarket.stamp.service.StampService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@Slf4j
public class StampController {
    private final StampService stampService;

    @PutMapping("/add")
    public Result<Object> add(@RequestBody Stamp stamp) {
        stampService.addStamp(stamp);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<Object> delete(@PathVariable Integer id) {
        log.info("deleting id=" + id.toString());
        stampService.deleteStamp(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<List<Stamp>> listAllStamp() {
        log.warn("Listing all stamps, may take a long time");
        return Result.success(stampService.listAllStamp());
    }

    @PutMapping("/modify/{id}")
    public Result<Object> modify(@PathVariable Integer id, @RequestParam Double price) {
        log.info("modifying id=" + id.toString());
        stampService.updateStampPrice(id, price);
        return Result.success();
    }

    @GetMapping("/price/{id}")
    public Integer price(@PathVariable Integer id) {
        log.info("querying price of stamp ID=" + id);
        return stampService.queryStampPrice(id);
    }
}
