package com.linkedbear.spring.zhanglong;

import com.linkedbear.spring.zhanglong.service.MyService;
import java.util.Arrays;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.DecoratingProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Stone
 * @date 2022/6/17
 */
public class SpringClientAop {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("zhanglong/xmlaspect2.xml") ;
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);
        MyService myService = (MyService) defaultListableBeanFactory.getBean("myAop");
        myService.myMethod();
        System.out.println(myService.getClass().getSuperclass());
        Arrays.stream(myService.getClass().getInterfaces()).forEach(System.out::println);
        DecoratingProxy decoratingProxy = (DecoratingProxy)myService;
        System.out.println(decoratingProxy.getDecoratedClass());
    }
}
