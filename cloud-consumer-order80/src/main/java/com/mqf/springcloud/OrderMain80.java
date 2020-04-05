package com.mqf.springcloud;

import com.mqf.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author mu_qingfeng
 * @date 2020/3/22 3:38 PM
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "SPRING-CLOUD-EXAMPLE-PERSON",configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
