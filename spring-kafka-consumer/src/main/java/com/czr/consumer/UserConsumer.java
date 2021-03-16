package com.czr.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserConsumer {

    @KafkaListener(topics = {"${spring.kafka.topic.userTopic}"})
    public void userConsumer(String message) {
        log.info("receive msg " + message);
    }
}
