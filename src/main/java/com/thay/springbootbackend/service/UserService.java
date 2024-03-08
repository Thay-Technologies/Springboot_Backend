package com.thay.springbootbackend.service;

import com.thay.springbootbackend.dto.UserDto;
import com.thay.springbootbackend.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<UserDto> getAllUsers();

    UserDto createNewUser(UserDto newUser);

    UserDto getOneUser(Long userId);

    UserDto updateOneUser(Long userId, UserDto newUser);

    Boolean deleteById(Long userId);


    User getOneUserByName(String username);

    Optional<User> getOneUserById (Long userId);
}
