package com.yb.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: yb
 * @Date: 2024/4/24 18:16
 * @Description:
 * @Version 1.0.0
 */
@Data
@TableName("t_user")
public class User {

    private int id;

    private String name;

    private Date birthday;

    private String adress;
}
