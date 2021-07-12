package com.example.fans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.example.fans.mapper")
public class FansApplication {

    public static void main(String[] args) {
        SpringApplication.run(FansApplication.class, args);
    }

}
