package com.tk.practice.ias.controller.kafka;

import com.tk.practice.ias.service.UserService;
import com.tk.practice.ias.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaController {

    private final UserService userService;

    @KafkaListener(topics = "users")
    public void consumeContact(final UserDTO userDTO) throws MessagingException {
        log.info("Consuming message from Kafka: " + userDTO.getEmail());
        userService.processUser(userDTO);
    }

}
