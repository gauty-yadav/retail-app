package com.retail.app.model;


import com.retail.app.dto.UserDto;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))

    private Set<Role> roles;

    public User() {
    }

    public User(long id, String firstName, String username, String password, Set roles) {
        this.id = id;
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.roles = roles;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public UserDto toUserDto(){
        UserDto userDto = new UserDto();
        userDto.setId(this.id);
        userDto.setFirstName(this.firstName);
        userDto.setUsername(this.username);
        userDto.setRole(this.roles.stream().map(role -> role.getName().toString()).collect(Collectors.toList()));
        return userDto;
    }
}
