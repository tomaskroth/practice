package com.tk.practice.ics.controller.rest;

import com.tk.practice.ics.domain.User;
import com.tk.practice.ics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> listUser() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping(value = "/{ID}")
    public ResponseEntity<User> getUser(@PathVariable("ID") final Long id) {
        return ResponseEntity.ok(userService.getUser(id).get());
    }

}
