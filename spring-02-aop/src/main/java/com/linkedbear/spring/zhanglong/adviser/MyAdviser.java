package com.linkedbear.spring.zhanglong.adviser;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Stone
 * @date 2022/6/17
 */
public class MyAdviser implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before myAdviser invoke");
        Object result = methodInvocation.proceed();
        System.out.println("after myAdviser invoke");
        return result;
    }
}
