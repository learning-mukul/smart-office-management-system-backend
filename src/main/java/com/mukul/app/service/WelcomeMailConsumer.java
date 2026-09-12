package com.mukul.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mukul.app.dto.EmployeeEvent;
import jakarta.mail.MessagingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WelcomeMailConsumer {

    private EmailService emailService;
    private ObjectMapper objectMapper;

    public WelcomeMailConsumer(EmailService emailService, ObjectMapper objectMapper){
        this.emailService= emailService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "welcome-topic", groupId= "group_id")
    public void consume(String message) throws MessagingException {
        try{
            EmployeeEvent event = objectMapper.readValue(message, EmployeeEvent.class);
            emailService.sendWelcomeMail(event.getEmail(),event.getName());
            System.out.println("sending welcome mail to: "+ event.getEmail()+" to "+event.getName());
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}

