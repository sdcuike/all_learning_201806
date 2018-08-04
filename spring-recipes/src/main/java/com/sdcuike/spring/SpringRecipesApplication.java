package com.sdcuike.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"com"},exclude = {DataSourceAutoConfiguration.class})
@ImportResource(value = "classpath*:/spring-context.xml")
public class SpringRecipesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRecipesApplication.class, args);
    }
}
