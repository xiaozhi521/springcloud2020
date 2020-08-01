package com.mqf.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author mu_qingfeng
 * @date 2020/7/19 6:05 PM
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {

    @Value("${server.port}")
    private String serverPort;

   @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
       System.out.println("消费者一号----->接收到的消息：" + message.getPayload() + "\t port:" + serverPort);
    }
}
