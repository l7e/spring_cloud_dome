package com.like.controller;


import com.like.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public User index(@PathVariable("id") Long id)
    {
        String url = "http://127.0.0.1:8081/user/" + id;
        return restTemplate.getForObject("http://127.0.0.1:8081/user/" + id, User.class);
    }

}