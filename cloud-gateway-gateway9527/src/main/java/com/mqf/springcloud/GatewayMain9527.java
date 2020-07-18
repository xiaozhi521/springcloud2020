package com.mqf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @create 2020-07-15 22:13
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class,args);
    }


//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeBuilder){
//        RouteLocatorBuilder.Builder routes = routeBuilder.routes();
//        routes.route("path_route_mqf", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
//        return routes.build();
//    }


    /**
     *  当访问 localhost:9527/guoji 时会自动转发到  http://news.baidu.com/guoji
     * @param routeBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeBuilder){
        return routeBuilder.routes()
                .route("test1", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
    }
}
