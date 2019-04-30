package com.like.controller;


import com.like.client.UserClient;
import com.like.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
@DefaultProperties(defaultFallback = "defaultCallBack")
public class UserController
{
    @Autowired
    private UserClient userClient;

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;

//    @Autowired
//    private RibbonLoadBalancerClient client;

//    @GetMapping("/{id}")
//    public User index(@PathVariable("id") Long id)
//    {
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

//        String url = "http://user-server/user/";
//        User user = restTemplate.getForObject(url + id, User.class);
//        System.out.println(user);
//        return user;
//    }

    /**
     *
     * 服务降级相关
     *
     */

//    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "fallCallback")
//    public String index(@PathVariable("id") Long id)
//    {
//        String url = "http://user-server/user/";
//        return restTemplate.getForObject(url + id, String.class);
//    }
//
//    public String fallCallback(Long id)
//    {
//        return "服务器压力很大1";
//    }

// //   @GetMapping("/{id}")
////    @HystrixCommand(commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") //指定当前降级时间
////    })
//    @HystrixCommand
//    public String index(@PathVariable("id") Long id)
//    {
//        String url = "http://user-server/user/";
//        return restTemplate.getForObject(url + id, String.class);
//    }
//
//    public String defaultCallBack()
//    {
//        return "服务器压力很大2";
//    }

    /**
     *
     * 熔断相关
     *
     */
//    @GetMapping("/{id}")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //最近请求的次数
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  //错误百分比
//    })
//    public String index(@PathVariable("id") Long id)
//    {
//        if (id % 2 == 0) {
//            throw new RuntimeException("");
//        }
//        String url = "http://user-server/user/";
//        return restTemplate.getForObject(url + id, String.class);
//    }
//
//    public String defaultCallBack()
//    {
//        return "服务器压力很大2";
//    }


    /**
     * feign相关
     */

    @GetMapping("/{id}")
    public String index(@PathVariable("id") Long id)
    {
        return userClient.queryById(id);
    }
}