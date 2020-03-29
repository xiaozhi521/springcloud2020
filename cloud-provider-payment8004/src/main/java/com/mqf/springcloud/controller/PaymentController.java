package com.mqf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author mu_qingfeng
 * @date 2020/3/29 11:09 AM
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/zk")
    public String paymentzk(){
        return "spring cloud with zookeeper:" + serverPort + " **** " + UUID.randomUUID().toString();
    }


}
