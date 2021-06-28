package com.eagle.my_spring_cloud.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eagle.my_spring_cloud.entity.Customer;
import com.eagle.my_spring_cloud.mapper.CustomerMapper;
import com.eagle.my_spring_cloud.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
}
