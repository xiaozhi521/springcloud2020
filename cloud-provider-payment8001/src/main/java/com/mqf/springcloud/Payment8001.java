package com.mqf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @create 2020-03-21 10:18
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后自动会自动注册进 eureka 服务中
@EnableDiscoveryClient  //服务发现
//@EnableCircuitBreaker   //对hystrixR熔断机制的支持
public class Payment8001 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class, args);
    }
}