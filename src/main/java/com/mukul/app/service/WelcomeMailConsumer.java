package com.mukul.app.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WelcomeMailConsumer {

    private EmailService emailService;

    public WelcomeMailConsumer(EmailService emailService){
        this.emailService= emailService;
    }

    @KafkaListener(topics = "welcome-topic", groupId= "group_id")
    public void consume(String email){
        emailService.sendWelcomeMail(email);
        System.out.println("sending welcome mail to: "+ email);
    }
}

