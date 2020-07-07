package com.tk.practice.ias.service;

import com.tk.practice.ias.service.dto.UserDTO;
import com.tk.practice.ias.domain.User;

import java.util.List;

public interface UserService {

    List<User> listRejected();

    List<User> listApproved();

    User getUserStatus(Long id);

    User processUser(UserDTO user);

}
