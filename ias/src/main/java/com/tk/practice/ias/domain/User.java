package com.tk.practice.ias.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;
    private String email;
    private String name;
    private Boolean approved = true;
    private String reason;

}
