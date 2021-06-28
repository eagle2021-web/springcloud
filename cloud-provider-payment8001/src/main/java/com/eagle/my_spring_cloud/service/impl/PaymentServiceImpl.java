package com.eagle.my_spring_cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eagle.my_spring_cloud.entity.Payment;
import com.eagle.my_spring_cloud.mapper.PaymentMapper;
import com.eagle.my_spring_cloud.service.PaymentService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {



}
