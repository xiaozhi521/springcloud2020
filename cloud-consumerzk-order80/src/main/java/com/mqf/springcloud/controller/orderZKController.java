package com.mqf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author mu_qingfeng
 * @date 2020/3/29 6:06 PM
 */
@RestController
@Slf4j
public class orderZKController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    public RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/paymentInfo")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk",String.class);
        return result;
    }
}
