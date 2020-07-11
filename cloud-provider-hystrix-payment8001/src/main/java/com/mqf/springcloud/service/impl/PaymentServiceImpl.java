package com.mqf.springcloud.service.impl;

import com.mqf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class PaymentServiceImpl implements PaymentService {


    /**
     * 正常访问，运行OK
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentInfoOK,id =" + id + "    O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_timeOut(Integer id) {
        int number = 3;
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentInfo_timeOut,id =" + id +
                "\tO(∩_∩)O哈哈~" + "\t耗时(秒)：" + number;
    }

}
