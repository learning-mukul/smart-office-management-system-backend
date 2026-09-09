package com.mukul.app.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WelcomeMailConsumer {

    @KafkaListener(topics = "welcome-topic", groupId= "group_id")
    public void consume(String email){
        System.out.println("sending welcome mail to: "+ email);
    }
}

