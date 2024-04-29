package com.yb.mybatisplus;

import com.yb.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void testDB(){
        userService.testDB();
    }

    @Test
    void query(){
        userService.query();
    }

    @Test
    void queryLamad(){
        userService.queryLamad();
    }

    @Test
    void count(){
        userService.count();
    }

    @Test
    void insert(){
        userService.insert();
    }

    @Test
    void update(){
        userService.update();
    }

    @Test
    void updateBatch(){
        userService.updateBatch();
    }

}
