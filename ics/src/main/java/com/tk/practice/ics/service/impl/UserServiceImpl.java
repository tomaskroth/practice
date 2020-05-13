package com.tk.practice.ics.service.impl;

import com.tk.practice.ics.domain.User;
import com.tk.practice.ics.domain.repository.UserRepository;
import com.tk.practice.ics.service.UserBroadcaster;
import com.tk.practice.ics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserBroadcaster userBroadcaster;

    @Override
    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        userBroadcaster.notifyAll(savedUser);
        return savedUser;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }


}
