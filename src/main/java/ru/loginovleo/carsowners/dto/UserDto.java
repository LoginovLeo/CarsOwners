package ru.loginovleo.carsowners.dto;

import java.util.Date;

public class UserDto {

    private String name;

    private String email;

    private String password;

    private Date registered;

    public UserDto(String name, String email, String password, Date registered) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registered = registered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
}
