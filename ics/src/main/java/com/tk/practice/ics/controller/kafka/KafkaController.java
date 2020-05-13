package com.tk.practice.ics.controller.kafka;

import com.tk.practice.ics.domain.User;
import com.tk.practice.ics.service.UserBroadcaster;
import org.springframework.stereotype.Component;

@Component
public class KafkaController implements UserBroadcaster {

    @Override
    public void notifyAll(User user) {
        System.out.println(user);
    }
}
