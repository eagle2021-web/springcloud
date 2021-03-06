package com.eagle.springcloud.controller;

import com.eagle.springcloud.entity.CommonResult;
import com.eagle.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; //注册中心的客户名字
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Boolean> create( Payment payment){
        log.info("80create");
        log.info(payment.getId() + "");
        //public <T> T postForObject(String url, @Nullable Object request, Class<T> responseType, Map<String, ?> uriVariables)
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("get id");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get"+ id, CommonResult.class);
    }
}
