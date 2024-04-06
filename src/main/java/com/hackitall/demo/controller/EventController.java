package com.hackitall.demo.controller;

import com.hackitall.demo.mock.MockGenerator;
import com.hackitall.demo.model.EnergyEventDAO;
import com.hackitall.demo.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class EventController {
    @Autowired
    KafkaMessagePublisher publisher;

    @PostMapping("/publish")
    public ResponseEntity<?> publishMessage() {
        try {
            EnergyEventDAO event = MockGenerator.generateEvent();
            publisher.sendMessageToTopic(event);
            return ResponseEntity.ok("Message Sent");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
