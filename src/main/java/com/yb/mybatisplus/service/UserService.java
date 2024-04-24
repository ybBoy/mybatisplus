package com.yb.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yb.mybatisplus.dao.UserMapper;
import com.yb.mybatisplus.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: yb
 * @Date: 2024/4/24 18:12
 * @Description:
 * @Version 1.0.0
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public void testDB(){
        int i = userMapper.testDB();
        System.out.println(i + " -- ********** ");
    }


    public void count(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("name", "张三");
        Long count = userMapper.selectCount(wrapper);
        System.out.println(" 条数：  " + count);
    }
}
