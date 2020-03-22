package com.mqf.springcloud.controller;

import com.mqf.springcloud.beans.CommonResult;
import com.mqf.springcloud.beans.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/customer")
public class PaymentControlelr {

    @Resource
    private RestTemplate restTemplate;


    public static final String PAYMENT_URL = "http://localhost:8001";


    @GetMapping(value = "/payment/add")
    public CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add",payment,CommonResult.class);
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

}
