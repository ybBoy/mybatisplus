package com.yb.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yb.mybatisplus.pojo.User;

/**
 * @Auther: yb
 * @Date: 2024/4/24 18:12
 * @Description:
 * @Version 1.0.0
 */
public interface UserService extends IService<User> {

    int delete();
}
