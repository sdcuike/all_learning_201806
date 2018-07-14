package com.sdcuike.dubbo.learning.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author sdcuike
 * @date 2018/5/31
 * @since 2018/5/31
 */
public class ProviderTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        context.start();

        TimeUnit.HOURS.sleep(1);

    }
}
