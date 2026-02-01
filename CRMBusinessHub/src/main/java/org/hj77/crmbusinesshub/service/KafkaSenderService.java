package org.hj77.crmbusinesshub.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaSenderService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    KafkaSenderService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String payload) {
        this.kafkaTemplate.send(topic, payload);
        log.info("Сообщение успешно отправлено! Topic={}, Payload={}", topic, payload);
    }
}
