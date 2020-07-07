package com.tk.practice.ias.service.validator;

import com.tk.practice.ias.service.dto.UserDTO;
import lombok.AllArgsConstructor;

import java.util.function.Predicate;

@AllArgsConstructor
public enum UserValidator {

    AGE((user)-> { return user.getAge() < 18;}, "User below minimum age");


    private Predicate<UserDTO> validationFunction;
    private String reasonRejected;


    public boolean isValid(UserDTO user) {
        return validationFunction.test(user);
    }

    public String getReason() {
        return reasonRejected;
    }

}
