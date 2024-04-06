package com.hackitall.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackitall.demo.mock.MockGenerator;
import com.hackitall.demo.model.EnergyEventDAO;
import com.hackitall.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@EnableScheduling
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(initialDelay = 5000, fixedRate = 15000)
    public void sendRandom() throws JsonProcessingException {
        List<EnergyEventDAO> mockEvents = MockGenerator.generateEvents();
        for (EnergyEventDAO mockEvent : mockEvents) {
            sendMessageToTopic(mockEvent);
        }
    }

    public void sendMessageToTopic(Object object) throws JsonProcessingException {
        String message = JsonUtil.convertToJsonString(object);
        CompletableFuture<SendResult<String, String>> futureMessage = kafkaTemplate.send("energyEvents", message);
        futureMessage.whenComplete((res, ex) -> {

            if (ex == null) {
                System.out.println("Sent message=[" + message + "]" +
                        "with offset=[" + res.getRecordMetadata().offset() + "]" +
                        "with topic=[" + res.getRecordMetadata().topic() + "]" +
                        "with partition=[" + res.getRecordMetadata().partition() + "]");
            } else {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
