package com.reserve.authservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by linxing on 29/07/2017.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private String username, password;
    private boolean active;

    public Account(String username, String password, boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }

}
