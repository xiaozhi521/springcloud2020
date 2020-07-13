package com.mqf.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.HystrixMetricsProperties;
import org.springframework.context.annotation.Bean;

/**
 * @create 2020-03-21 10:18
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后自动会自动注册进 eureka 服务中
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker   //对hystrixR熔断机制的支持
public class Payment8001 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class,args);
    }


    /**
     * 此配置是为了服务监控而配置，与服务器本身无关，springcloud 升级后的坑
     * ServletRegistrationBean 因为 springcloud 的默认路径不是 /hystrix.stream
     * 只要在自己的项目里配置上下面的servlet就可以了
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
