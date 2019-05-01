package com.like.client;


        import org.springframework.stereotype.Component;

@Component      //需要加上次注解
public class UserClientImpl implements UserClient
{
    @Override
    public String queryById(Long id)
    {
        //这里返回异常信息
        return "feign异常";
    }
}
