package com.mqf.springcloud.controller;

import com.mqf.springcloud.beans.CommonResult;
import com.mqf.springcloud.beans.Payment;
import com.mqf.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/customer")
public class OrderControlelr {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;


//    public static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";


    @GetMapping(value = "/payment/add")
    public CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add",payment,CommonResult.class);
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping(value = "/get/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        } else {
            return new CommonResult<>(444,"操作失败");
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instanceList == null || instanceList.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instanceList);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb",String.class);
    }


}
