package com.yb.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yb.mybatisplus.dao.UserMapper;
import com.yb.mybatisplus.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Auther: yb
 * @Date: 2024/5/6 09:19
 * @Description:
 * @Version 1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{


    @Override
    public int delete() {
        QueryWrapper<User> wrapper = new QueryWrapper<>(User.builder().id(1L).build());
        return getBaseMapper().delete(wrapper);
    }
}
