package com.hackitall.demo.controller;

import com.hackitall.demo.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class EventController {
    @Autowired
    KafkaMessagePublisher publisher;
}
