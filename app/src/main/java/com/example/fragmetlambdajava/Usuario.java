package com.example.fragmetlambdajava;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Usuario implements Serializable {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

    public Usuario(String userName, String fgit irstName, String lastName, String email, String password, String phone) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}
