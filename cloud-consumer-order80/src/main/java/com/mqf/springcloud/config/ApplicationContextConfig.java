package com.mqf.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author mu_qingfeng
 * @date 2020/3/22 3:59 PM
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced   //使用 @LoadBalanced 注解赋予RestTemplate 负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
