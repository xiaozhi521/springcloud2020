package com.mqf.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author mu_qingfeng
 * @date 2020/7/12 4:09 PM
 */
@Component
public class PaymentFallbackService implements OrderHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-- PaymentFallbackService fall back : paymentInfo_OK()";
    }

    @Override
    public String paymentInfo_timeOut(Integer id) {
        return "-- PaymentFallbackService fall back : paymentInfo_timeOut()";
    }
}
