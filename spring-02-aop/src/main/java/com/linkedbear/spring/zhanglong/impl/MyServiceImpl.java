package com.linkedbear.spring.zhanglong.impl;

import com.linkedbear.spring.zhanglong.service.MyService;

/**
 * @author Stone
 * @date 2022/6/17
 */
public class MyServiceImpl implements MyService {

    @Override
    public void myMethod() {
        System.out.println("myMethod invoked");
    }
}
