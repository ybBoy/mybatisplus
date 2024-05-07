package com.yb.mybatisplus.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Auther: yb
 * @Date: 2024/4/30 16:12
 * @Description:
 * @Version 1.0.0
 */
public class FunctionUtil {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + 1);
        }

        List<String> to = ConsumentF.to(list, e -> (String.valueOf(e)));
        to.stream().forEach(System.out::println);
    }
}

class ConsumentF{

    public static <T, E> List<T> to(List<E> list, Function<E, T> consu){
        List<T> ts = list.stream().map(consu).collect(Collectors.toList());
        return ts;
    }
}