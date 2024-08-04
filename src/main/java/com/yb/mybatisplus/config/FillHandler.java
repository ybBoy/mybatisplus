package com.yb.mybatisplus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: yb
 * @Date: 2024/5/6 13:39
 * @Description: 自动给表的默认字段赋值
 * @Version 1.0.0
 */
@Component
public class FillHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("cjsj", new Date(), metaObject);
        setFieldValByName("gxsj", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("gxsj", new Date(), metaObject);
    }
}
