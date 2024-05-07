package com.yb.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.yb.mybatisplus.pojo.User;
import com.yb.mybatisplus.service.UserService;
import com.yb.mybatisplus.util.RandomName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void count(){
        LambdaQueryChainWrapper<User> wrapper = userService.lambdaQuery(User.builder().name("何云雪").build());
        Long count = wrapper.count();
        System.out.println(count);
    }

    public int getAge(){
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    @Test
    void save(){
        boolean b = userService.save(User.builder()
                        .age(getAge()).name(RandomName.build())
                .build());
        System.out.println(b);

    }

    /**
     *  批量插入，需要url 增加 rewriteBatchedStatements=true 开启批量新增
     */
    @Test
    void saveBatch(){
        long start = System.currentTimeMillis();
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(User.builder().age(getAge()).name(RandomName.build()).build());
        }
        boolean b = userService.saveBatch(list);
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
    }

    @Test
    void list(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "金白新");
        List<User> list = userService.list(wrapper);
        System.out.println(list);
    }

    @Test
    void listLambda(){
        String name = "金白新";
        LambdaQueryChainWrapper<User> wrapper = userService.lambdaQuery();
        wrapper.select(User::getName, User::getId, User::getAge);
        wrapper.eq(name != null && !"".equals(name), User::getName, name);
        List<User> list = wrapper.list();
        System.out.println(list);
    }

    @Test
    void updateById(){
        boolean b = userService.updateById(User.builder().id(1L).age(23).build());
        System.out.println(b);
    }

    @Test
    void update(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", 1);
        wrapper.set("age", 33);
        boolean b = userService.update(wrapper);
        System.out.println(b);
    }

    @Test
    void updateLambda(){
        LambdaUpdateChainWrapper<User> wrapper = userService.lambdaUpdate();
        wrapper.eq(User::getId, 1);
        wrapper.set(User::getAge, 20);
        boolean b = wrapper.update();
        System.out.println(b);
    }

    @Test
    void delete(){
        int b = userService.delete();
        System.out.println(b);
    }

    @Test
    void remove(){
        QueryWrapper<User> wrapper = new QueryWrapper<>(User.builder().id(1L).build());
        wrapper.eq("id", 1);
        Boolean b = userService.remove(wrapper);
        System.out.println(b);
    }

}
