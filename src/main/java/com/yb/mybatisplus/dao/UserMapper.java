package com.yb.mybatisplus.dao;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.yb.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: yb
 * @Date: 2024/4/24 18:15
 * @Description:
 * @Version 1.0.0
 */
public interface UserMapper extends BaseMapper<User> {

    int testDB();

    int updateBatchByIds(@Param("age") int age, @Param(Constants.WRAPPER) UpdateWrapper<User> wrapper);
}
