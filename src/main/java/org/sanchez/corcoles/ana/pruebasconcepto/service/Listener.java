package org.sanchez.corcoles.ana.pruebasconcepto.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener {

    private static final String TOPIC_NAME = "message-topic";
    private static final String GROUP_ID = "group";

    @KafkaListener(topics = TOPIC_NAME, groupId = "group")
    public void listener(String message) {
        log.info("Message received {}", message);
    }
}
