package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka.model.Employee;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "demo_topic";

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
   
    public void sendEmployeeObject(Employee emp) {
        kafkaTemplate.send(TOPIC, emp.toString());
    }
}
