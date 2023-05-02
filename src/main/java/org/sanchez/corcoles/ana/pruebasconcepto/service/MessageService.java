package org.sanchez.corcoles.ana.pruebasconcepto.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {

    private static final String TOPIC_NAME = "message-topic";

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;

    public void send(String message) {
        log.info("Message {} has been sent", message);
        kafkaTemplate.send(TOPIC_NAME, message);
    }
}
