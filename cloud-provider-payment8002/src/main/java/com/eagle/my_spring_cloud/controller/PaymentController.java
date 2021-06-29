package com.eagle.my_spring_cloud.controller;

import com.eagle.my_spring_cloud.service.impl.PaymentServiceImpl;
import com.eagle.springcloud.entity.CommonResult;
import com.eagle.springcloud.entity.Payment;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private EurekaDiscoveryClient eurekaDiscoveryClient;
    @Resource
    private PaymentServiceImpl paymentServiceImpl;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = {"/payment/create"})
    public CommonResult<Boolean> create(@RequestBody Payment payment){
        log.info(payment.getId()+"");

        boolean save = paymentServiceImpl.save(payment);
        log.info("插入结果：" + save);
        if(save){
            return new CommonResult<>(200, "插入数据库成功 + server-port" + serverPort, true);
        }else {
            return new CommonResult<>(444, "插入数据库失败 + server-port" + serverPort, false);
        }
    }
    @GetMapping(value = {"/payment/get/{id}"})
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentServiceImpl.getById(id);
        log.info("查询id得到的实体是"+payment);
        if(payment != null){
            return new CommonResult<>(200,"查询成功",payment);
        }else {
            return new CommonResult<>(444,"没有对应记录，查询ID" + id, null);
        }
    }
    @GetMapping(value = {"/payment/discovery"})
    public Object discovery(){
        List<ServiceInstance> instances = eurekaDiscoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId() + instance.getHost() + instance.getPort() + instance.getUri());
        }
        return this.eurekaDiscoveryClient;
    }
}