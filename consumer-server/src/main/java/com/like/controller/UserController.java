package com.like.controller;


import com.like.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Year;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

//    @Autowired
//    private RibbonLoadBalancerClient client;

    @GetMapping("/{id}")
    public User index(@PathVariable("id") Long id)
    {
//        //根据服务id获取服务的实例,注意这里是一个list,因为同名的服务可能有多个实例(集群)
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-server");
//        ServiceInstance instance = instances.get(0);
//        //获取服务的ip和port拼接进行访问
//        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/";
//
//        return restTemplate.getForObject(url + id, User.class);


        //使用ribbon,内部已经用负载均衡为我们获取了实例
//        ServiceInstance instance = client.choose("user-server");

//        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/";

        String url = "http://user-server/user/";
        User user = restTemplate.getForObject(url + id, User.class);
        System.out.println(user);
        return user;
    }

}