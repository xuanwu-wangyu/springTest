package com.test1;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class testMain {
    public static void main(String[] args) {

        Resource resource = new ClassPathResource("application.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
        Object demo1 = xmlBeanFactory.getBean("demo1");

        System.out.println(demo1);
     /*   ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        methodTest demo2 = (methodTest) classPathXmlApplicationContext.getBean("demo1");*/

    }
}
