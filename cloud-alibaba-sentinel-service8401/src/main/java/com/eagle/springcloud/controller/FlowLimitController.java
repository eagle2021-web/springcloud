package com.eagle.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RefreshScope  //支持Nacos的动态刷新功能
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        long id = Thread.currentThread().getId();

        return "-----testA    + " + id;
    }
    @GetMapping("/testB")
    public String testB(){
        return "-----testB";
    }
    @GetMapping("/testD")
    public String testD(HttpServletRequest request){
        try {
            Thread.sleep(1000);
        }catch (Exception err){

        };
        log.info("testD");
        return "-----testD";
    }
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey") //如果违背了热点规则，就调用deal_...
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        log.info(p2);
        return "------testHotKey-----";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "-----deal_testHotKey------";
    }
}
