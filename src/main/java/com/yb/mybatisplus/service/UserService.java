package com.yb.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yb.mybatisplus.dao.UserMapper;
import com.yb.mybatisplus.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    public void query(){
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .select("name", "id", "adress", "birthday")
                .like("name", "张三")
                .likeRight("name", "张")
                ;
        List<User> list = userMapper.selectList(wrapper);
        list.stream().forEach(System.out::println);
    }

    public void queryLamad(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getName, User::getId, User::getAdress)
                .like(User::getName, "张三");
        List<User> list = userMapper.selectList(wrapper);
        list.stream().forEach(System.out::println);
    }

    public void count(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("name", "张三");
        Long count = userMapper.selectCount(wrapper);
        System.out.println(" 条数：  " + count);
    }

    public void insert() {
        User user = User.builder()
                .name("张三")
                .adress("紫禁城")
                .cjsj(new Date()).gxsj(new Date())
                .birthday(new Date())
                .build();
        int insert = userMapper.insert(user);
    }

    public void update(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>().eq("id", 1);
        User user = User.builder().name("李四")
                .adress("故宫")
                .birthday(new Date()).cjsj(new Date()).gxsj(new Date())
                .build();
        userMapper.update(user, wrapper);
    }

    public void updateBatch() {

        UpdateWrapper<User> wrapper = new UpdateWrapper<User>().in("id", 1, 2);
        userMapper.updateBatchByIds(2, wrapper);

    }
}
