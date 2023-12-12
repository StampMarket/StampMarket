package com.stampmarket.user.handler;

import com.stampmarket.common.pojo.Result;
import com.stampmarket.user.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获未知异常
     */
    @ExceptionHandler
    public Result<Object> exceptionHandler(Exception e){
        log.error("未知异常：{}", e.getMessage());
        return Result.error("未知异常");
    }

    /**
     * 捕获业务异常
     */
    @ExceptionHandler
    public Result<Object> exceptionHandler(CustomException e){
        log.info("业务异常：{}", e.getMessage());
        return Result.error(400, e.getMessage());
    }
}
