package com.tk.practice.ias.service.impl;

import com.tk.practice.ias.domain.User;
import com.tk.practice.ias.domain.UserRepository;
import com.tk.practice.ias.service.UserService;
import com.tk.practice.ias.service.dto.UserDTO;
import com.tk.practice.ias.service.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<User> listRejected() {
        return userRepository.findUserByApproved(false);
    }

    @Override
    public List<User> listApproved() {
        return userRepository.findUserByApproved(true);
    }

    @Override
    public User getUserStatus(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User processUser(UserDTO userDTO) {

        var user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());

        if (!UserValidator.AGE.isValid(userDTO)) {
            user.setApproved(false);
            user.setReason(UserValidator.AGE.getReason());
        }

        return userRepository.save(user);
    }
}
