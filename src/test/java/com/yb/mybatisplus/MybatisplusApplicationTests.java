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
    void count(){
        userService.count();
    }

}
