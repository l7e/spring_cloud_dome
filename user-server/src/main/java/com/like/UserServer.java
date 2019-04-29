package com.like;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.like.mapper")
@EnableDiscoveryClient
public class UserServer
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserServer.class);
    }
}
