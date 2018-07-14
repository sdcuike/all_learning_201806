package com.sdcuike;

import com.sdcuike.HelloWorld.Demo;
import org.nustaq.serialization.FSTConfiguration;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author sdcuike
 * @date 2018/6/8
 * @since 2018/6/8
 */
public class Hello2 {
    static FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();
    
    public static void main(String[] args) {
        Demo demo = new Demo(11, "doctor");
        
        byte[] bytes = conf.asByteArray(demo);
        System.out.println(Base64.getEncoder().encodeToString(bytes));
        final String str = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8)));
        
        Demo demo2 = (Demo) conf.asObject(bytes);
        System.out.println(demo2);
    }
    
}
