package com.eagle.my_spring_cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@TableName("spring_cloud")
public class CommonResult <T>{
    private Integer code;
    private String message;
    private T data;

    //data有可能为null， 2参构造器
//    public CommonResult(Integer code, String message) {
//        this(code,message);
//    }
}
