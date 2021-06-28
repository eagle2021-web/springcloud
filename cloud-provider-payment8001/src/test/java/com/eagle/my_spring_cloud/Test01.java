package com.eagle.my_spring_cloud;

import com.eagle.my_spring_cloud.entity.Payment;
import com.eagle.my_spring_cloud.mapper.PaymentMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test01 {
    @Autowired
    private PaymentMapper paymentMapper;

    @DisplayName("a01")
    @Test
    void test01(){
        Payment payment = paymentMapper.selectById(1);
    }
}
