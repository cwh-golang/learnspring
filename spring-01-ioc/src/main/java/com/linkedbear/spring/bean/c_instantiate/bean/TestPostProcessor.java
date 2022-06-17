package com.linkedbear.spring.bean.c_instantiate.bean;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.aop.framework.autoproxy.AbstractBeanFactoryAwareAdvisingPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * @author Stone
 * @date 2022/6/9
 */
@Component
public class TestPostProcessor extends AbstractBeanFactoryAwareAdvisingPostProcessor
        implements EnvironmentAware {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        System.out.println(beanName);
        Arrays.stream(methods).forEach(System.out::println);
        System.out.println();
        return bean;
    }

    @Override
    public void setEnvironment(Environment environment) {

    }
}
