package com.kchen.mas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MyAmazonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyAmazonServiceApplication.class, args);
    }

}
