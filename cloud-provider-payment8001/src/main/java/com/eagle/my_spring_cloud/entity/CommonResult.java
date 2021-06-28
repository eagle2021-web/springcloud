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
}
