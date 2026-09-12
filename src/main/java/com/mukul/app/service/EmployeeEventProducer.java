package com.mukul.app.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mukul.app.dto.EmployeeEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public EmployeeEventProducer(KafkaTemplate<String,String> kafkaTemplate, ObjectMapper objectMapper){
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendWelcomeEvent(String name, String email){
        try{
            EmployeeEvent event = new EmployeeEvent(name, email);
            String payload = objectMapper.writeValueAsString(event);
            kafkaTemplate.send("welcome-topic",payload);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
