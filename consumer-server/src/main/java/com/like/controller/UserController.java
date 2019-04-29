package com.like.controller;


import com.like.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User index(@PathVariable("id") Long id)
    {
        //根据服务id获取服务的实例,注意这里是一个list,因为同名的服务可能有多个(集群)
        List<ServiceInstance> instances = discoveryClient.getInstances("user-server");
        ServiceInstance instance = instances.get(0);
        //获取服务的ip和port拼接进行访问
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/";

        return restTemplate.getForObject(url + id, User.class);
    }

}