package com.mqf.springcloud.controller;

import com.mqf.springcloud.beans.CommonResult;
import com.mqf.springcloud.beans.Payment;
import com.mqf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentControlelr {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/add")
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("***** " + serverPort + " 插入结果：" + result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功" + serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败" + serverPort,null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***** " + serverPort + " 获取结果：" + payment);
        if(payment != null){
            return new CommonResult(200,"查询成功" + serverPort,payment);
        }else{
            return new CommonResult(444,"查询失败" + serverPort,null);
        }
    }

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for(String str : services){
            System.out.println("**********" + str);
        }


        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : serviceInstanceList) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t"
                    + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    /**
     * 服务提供端测试超时方法
     * @return
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        //暂停几秒
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }

}
