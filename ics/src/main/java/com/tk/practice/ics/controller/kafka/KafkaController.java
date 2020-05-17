package com.tk.practice.ics.controller.kafka;

import com.tk.practice.ics.domain.User;
import com.tk.practice.ics.service.UserBroadcaster;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class KafkaController implements UserBroadcaster {

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Override
    public void notifyAll(User user) {
        kafkaTemplate.send(new ProducerRecord<>("users", UUID.randomUUID().toString(), user));
    }
}
