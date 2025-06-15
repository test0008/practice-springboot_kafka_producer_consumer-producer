package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.kafka.model.Employee;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/publish")
    public void sendMessage(@RequestParam String message) {
        producerService.sendMessage(message);
    }


    @PostMapping("/employeePublish")
    public void sendEmployeeObject(@RequestBody Employee emp) {
        producerService.sendEmployeeObject(emp);
    }
}
