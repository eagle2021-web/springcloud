package com.eagle.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.eagle.springcloud.entity.CommonResult;
import com.eagle.springcloud.entity.Payment;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "按客户自定义,global handlerException", null);
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "按客户自定义,global handlerException222", null);
    }
}
