package com.eagle.springcloud.controller;

import com.eagle.springcloud.entity.CommonResult;
import com.eagle.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AA {
    @GetMapping(value = "aa")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }
}
