package com.linkedbear.spring.bean.c_instantiate;

import com.linkedbear.spring.bean.c_instantiate.config.BeanInstantiateConfiguration;
import java.util.Arrays;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BeanInstantiateAnnoApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanInstantiateConfiguration.class);
//        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource(""));
        ctx.getBean("");
        xmlBeanFactory.getBean("");
    }

}
