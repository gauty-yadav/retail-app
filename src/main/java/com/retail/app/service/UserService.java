package com.retail.app.service;

import com.retail.app.dto.UserDto;
import com.retail.app.model.User;

import java.util.List;

public interface UserService {

    UserDto save(UserDto user);
    List<UserDto> findAll();
    User findOne(long id);
    void delete(long id);
}
