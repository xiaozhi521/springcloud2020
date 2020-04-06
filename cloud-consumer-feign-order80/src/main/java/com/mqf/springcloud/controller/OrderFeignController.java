package com.mqf.springcloud.controller;

import com.mqf.springcloud.beans.CommonResult;
import com.mqf.springcloud.beans.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.mqf.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

/**
 * @author mu_qingfeng
 * @date 2020/3/29 6:06 PM
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/customer/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        System.out.println("11111111111");
        return paymentFeignService.getPaymentById(id);
    }
}
