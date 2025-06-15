package com.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.kafka.model.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

	private static final Logger log = LoggerFactory.getLogger(KafkaController.class);
	
    @Autowired
    private ProducerService producerService;

    @PostMapping("/publish")
    public void sendMessage(@RequestParam String message) {
        producerService.sendMessage(message);
    }


    @PostMapping("/employeePublish")
    public void sendEmployeeObject(@RequestBody Employee emp) {
    	log.info("API called to send Employee Object via Kafka Topic.");
        producerService.sendEmployeeObject(emp);
    }
}
