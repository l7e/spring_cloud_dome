package com.like.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "user-server",fallback = UserClientImpl.class)  //服务名称
public interface UserClient
{
    @GetMapping("/user/{id}")
    String queryById(@PathVariable("id") Long id);      //方法名随意
}
