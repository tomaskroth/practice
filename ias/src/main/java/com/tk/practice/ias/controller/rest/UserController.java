package com.tk.practice.ias.controller.rest;

import com.tk.practice.ias.domain.User;
import com.tk.practice.ias.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("rejected")
    public ResponseEntity<List<User>> listRejectedUsers() {
        return ResponseEntity.ok(userService.listRejected());
    }

    @GetMapping("approved")
    public ResponseEntity<List<User>> listApprovedUsers() {
        return ResponseEntity.ok(userService.listApproved());
    }

    @GetMapping("{ID}")
    public ResponseEntity<User> getUser(@PathVariable("ID") Long id) {
        return ResponseEntity.ok(userService.getUserStatus(id));
    }

}
