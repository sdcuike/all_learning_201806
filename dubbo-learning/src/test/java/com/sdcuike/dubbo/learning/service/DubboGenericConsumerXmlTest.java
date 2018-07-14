package com.sdcuike.dubbo.learning.service;

import com.alibaba.dubbo.rpc.service.GenericService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author sdcuike
 * @date 2018/7/14
 * @since 2018/7/14
 */
public class DubboGenericConsumerXmlTest {

    GenericService hystrixService;

    @Before
    public void init() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});

        hystrixService = (GenericService) context.getBean("hystrixService");
    }


    @Test
    public void testGenerRe_参数为基本类型_参数类型传递() throws InterruptedException {


        Object result = hystrixService.$invoke("testGenerRe", new String[]{"java.lang.String"}, new Object[]{"test"});

        Assert.assertEquals("haha test", result.toString());

    }

    @Test
    public void testGenerRe_参数为基本类型_参数类型不传递() throws InterruptedException {


        Object result = hystrixService.$invoke("testGenerRe", null, new Object[]{"test"});

        Assert.assertEquals("haha test", result.toString());

    }

    @Test
    public void test_echo_无参数_有重载方法() {

        final Object echo = hystrixService.$invoke("echo", new String[]{}, null);

        Assert.assertEquals("hello no param", echo.toString());
    }

}
