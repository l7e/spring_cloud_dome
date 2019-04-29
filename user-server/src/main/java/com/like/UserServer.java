package com.like;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.like.mapper")
@EnableEurekaClient
public class UserServer
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserServer.class);
    }
}
