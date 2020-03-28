package com.mqf.springcloud.service;

import com.mqf.springcloud.beans.Payment;

public interface PaymentService {
    int add(Payment payment);

    Payment getPaymentById(Long id);
}
