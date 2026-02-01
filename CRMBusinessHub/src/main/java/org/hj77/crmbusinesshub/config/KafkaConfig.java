
package org.hj77.crmbusinesshub.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KafkaConfig {

    @Bean
    public NewTopic exampleTopic() {
        return new NewTopic("data-guardian", 1, (short) 1); // partitions, replication factor
    }
}


