package com.mqf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author mu_qingfeng
 * @date 2020/4/5 9:27 PM
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
