package com.eagle.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.eagle.springcloud.entity.CommonResult;
import com.eagle.springcloud.entity.Payment;
import com.eagle.springcloud.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class RateLimitController {
    @GetMapping(value = "/byResource",produces = { "application/json;charset=UTF-8" })
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    @GetMapping(value = "aaa", produces = { "application/json;charset=UTF-8" })
    public Payment aaa() {
        return new Payment(111L, "abandon");
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用", null);
    }

    @GetMapping(value = "/reateLimit/customerBlockHandler" , produces = { "application/json;charset=UTF-8" })
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200 , "按客户自定义", new Payment(2020L, "serial003"));
    }
}
