package com.tk.practice.ics.service;

import com.tk.practice.ics.domain.User;

public interface UserBroadcaster {

    void notifyAll(User user);
}
