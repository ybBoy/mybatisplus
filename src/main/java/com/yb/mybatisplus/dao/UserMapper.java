package com.yb.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yb.mybatisplus.pojo.User;

/**
 * @Auther: yb
 * @Date: 2024/4/24 18:15
 * @Description:
 * @Version 1.0.0
 */
public interface UserMapper extends BaseMapper<User> {

    int testDB();

}
