package com.mqf.springcloud.controller;

import com.mqf.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mu_qingfeng
 * @date 2020/7/11 6:56 PM
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMehtod")
public class OrderHyxtrisController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = orderHystrixService.paymentInfo_OK(id);
        return result;
    }


    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallBackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_timeOut(@PathVariable("id") Integer id){
        int number = 10/0;
        String result = orderHystrixService.paymentInfo_timeOut(id);
        return result;
    }

    public String paymentTimeOutFallBackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙，请10秒后再试；或自己运行报错，请检查自己！o(╥﹏╥)o";
    }

    /**
     *  全局的异常处理方法
     * @return
     */
    public String paymentGlobalFallbackMehtod(){
        return "Global 异常处理信息，请稍后再试！o(╥﹏╥)o";
    }


}
