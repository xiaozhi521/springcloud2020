package com.mqf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mu_qingfeng
 * @date 2020/3/28 8:36 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class,args);
    }
}
