package com.tk.practice.ics.service;

import com.tk.practice.ics.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Method responsible for adding a new user to the system
     * @param user
     * @return Created user
     */
    User createUser(final User user);

    /**
     * Method responsible for listing all available users
     * @return List of Users
     */
    List<User> listUsers();

    /**
     * Fetch the user by the provided ID
     * @param id
     * @return User
     */
    Optional<User> getUser(Long id);

}
