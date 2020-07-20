package com.mqf.study.service.impl;


import com.mqf.study.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author mu_qingfeng
 * @date 2020/7/19 5:43 PM
 */
@EnableBinding(Source.class)    //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {


    @Resource
    private MessageChannel output;  //消息发送管道

    @Override
    public String send() {
        String str = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(str).build());
        System.out.println("********str:" +str);
        return null;
    }
}
