package com.sdcuike.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author sdcuike
 * @date 2018/8/5
 * @since 2018/8/5
 */
public class JMXTest {

    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/spring-context.xml","classpath*:/spring-property.xml");


        context.refresh();
        context.start();

        TimeUnit.HOURS.sleep(1);
    }
}
