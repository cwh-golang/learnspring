package com.linkedbear.spring.zhanglong;

import com.linkedbear.spring.zhanglong.service.MyService;
import java.util.Arrays;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.DecoratingProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/*
 * BeanFactory是SpringIOC工厂，它管理着spring所创建出来的各种bean对象，当我们在配置文件（注解）中声明了某个bean的id后，通过
 * 这个id就可以获取到与该id所对应的class的实例（可能是创建，也可能是从缓存中获取）
 *
 * FactoryBean本质上也是一个bean，他和其他bean一样，也是由beanFactory所管理和维护，它的实例也会缓存到容器中，
 * 它与普通的bean的唯一区别在于，当spring创建一个factoryBean实例后，他接下来会判断当前所创建的是否是一个factorybean实例，
 * 如果不是，则直接将这个bean返回个客户端；如果是，则会做进一步的处理，根据配置文件的target，advisor，interface等信息，
 * 在运行期构建出来一个类，并生成该类的一个对象，返回给客户端；因此，我们在声明一个factorybean的时候，通过id获取的，并非
 * 这个factorybean的实例，而是他动态生成的一个代理对象（通过三总方式生成）
 * */

/**
 * @author Stone
 * @date 2022/6/17
 */
public class SpringClientAop {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("zhanglong/xmlaspect2.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);
        MyService myService = (MyService) defaultListableBeanFactory.getBean("myAop");
        myService.myMethod();
        System.out.println(myService.getClass().getSuperclass());
        Arrays.stream(myService.getClass().getInterfaces()).forEach(System.out::println);
        DecoratingProxy decoratingProxy = (DecoratingProxy) myService;
        System.out.println(decoratingProxy.getDecoratedClass());
    }
}
