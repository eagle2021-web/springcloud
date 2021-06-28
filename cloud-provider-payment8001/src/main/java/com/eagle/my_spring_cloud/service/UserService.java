package com.eagle.my_spring_cloud.service;


import java.util.List;

import com.eagle.my_spring_cloud.entity.User;

/**
 *  Service 的CRUD也不用写了
 */
public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
