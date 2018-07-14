package com.sdcuike;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nustaq.serialization.FSTConfiguration;

import java.io.Serializable;

/**
 * Hello world!
 */
public class HelloWorld {
    static FSTConfiguration conf = FSTConfiguration.createJsonConfiguration(false, true);
    
    static {
    
    }
    
    public static void main(String[] args) {
        Demo demo = new Demo(11, "doctor");
        String jsonString = conf.asJsonString(demo);
        System.out.println(jsonString);
        
        
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Demo implements Serializable {
        private int age;
        private String name;
    }
}
