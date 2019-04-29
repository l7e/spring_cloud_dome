package com.like;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerServer
{
    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerServer.class);
    }


    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
