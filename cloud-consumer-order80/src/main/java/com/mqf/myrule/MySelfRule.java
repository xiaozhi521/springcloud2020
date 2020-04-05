package com.mqf.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mu_qingfeng
 * @date 2020/4/5 8:50 PM
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();// Ribbon默认是轮询，我自定义为随机
        //return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机

    }
}
