package com.mqf.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class PaymentServiceImpl {


    /**
     * 正常访问，运行OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentInfoOK,id =" + id + "    O(∩_∩)O哈哈~";
    }

    /**
     * @HystrixProperty 从 HystrixCommandProperties 类中查找
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_timeOut(Integer id) {
        //异常测试
//        int number = 10/0;
        //超时测试
        int number = 3;
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_timeOut,id = " + id +
                "\tO(∩_∩)O哈哈~" + "\t耗时(秒)：" + number;
    }

    public String paymentInfo_timeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "  80 系统繁忙或运行报错，请稍后再试！id = " + id +
                "\to(╥﹏╥)o";
    }

}
