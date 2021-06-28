package com.eagle.my_spring_cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eagle.my_spring_cloud.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
