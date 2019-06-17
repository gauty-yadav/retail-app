package com.retail.app.dto;

import java.util.List;

public class UserDto {

    private long id;
    private String firstName;
    private String username;
    private String password;
    private List<String> role;

    public UserDto() {
    }

    public UserDto(String firstName, String username, String password, List<String> role) {
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
