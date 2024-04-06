package com.hackitall.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hackitall.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToTopic(Object object) throws JsonProcessingException {
        String message = JsonUtil.convertToJsonString(object);
        CompletableFuture<SendResult<String, String>> futureMessage = kafkaTemplate.send("test", message);
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
