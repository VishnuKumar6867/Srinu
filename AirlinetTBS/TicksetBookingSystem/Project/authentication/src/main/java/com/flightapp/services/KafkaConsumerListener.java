package com.flightapp.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {

    private static final String TOPIC = "Airline";

    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(String message) {
        System.out.println("Consumed message from producer is : " + message);
    }

}
