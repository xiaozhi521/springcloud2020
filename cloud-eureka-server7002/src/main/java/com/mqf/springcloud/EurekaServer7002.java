package com.mqf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author mu_qingfeng
 * @date 2020/3/28 4:33 PM
 */
@SpringBootApplication
@EnableEurekaServer  //该注解表示eureka服务端
public class EurekaServer7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002.class,args);
    }
}
