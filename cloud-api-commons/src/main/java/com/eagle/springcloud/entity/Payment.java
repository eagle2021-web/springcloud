package com.eagle.springcloud.entity;

//import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
//@TableName("payment")
public class Payment {
    private Long id;
    private String serial;
}
