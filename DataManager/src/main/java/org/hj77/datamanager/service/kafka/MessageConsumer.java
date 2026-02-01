package org.hj77.datamanager.service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageConsumer {

    @KafkaListener(topics = "demo-topic", groupId = "my-group")
    public void listen(String message) {
        log.info(message);
        //System.out.println("Получено сообщение: " + message);
    }

}
