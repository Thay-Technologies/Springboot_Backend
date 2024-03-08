package com.thay.springbootbackend.service.impl;

import com.thay.springbootbackend.dto.UserDto;
import com.thay.springbootbackend.entity.User;
import com.thay.springbootbackend.repository.UserRepository;
import com.thay.springbootbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private UserDto converter(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(converter(user));
        }
        return userDtos;
    }

    @Override
    public UserDto createNewUser(UserDto newUserDto) {

        User user = new User();
        user.setUsername(newUserDto.getUsername());
        user.setPassword(newUserDto.getPassword());
        userRepository.save(user);

        return converter(user);
    }

    @Override
    public UserDto getOneUser(Long userId) {

        Optional<User> user = userRepository.findById(userId);

        return user.map(this::converter).orElse(null);

    }

    @Override
    public UserDto updateOneUser(Long userId, UserDto newUser) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Check if the new username is not empty before updating
            String newUsername = newUser.getUsername();
            if (newUsername != null && !newUsername.isEmpty()) {
                user.setUsername(newUsername);
            }

            // Encrypt the new password before updating
            String newPassword = newUser.getPassword();
            if (newPassword != null && !newPassword.isEmpty()) {
                user.setPassword(passwordEncoder.encode(newPassword));
            }

            userRepository.save(user);
            return converter(user);
        }

        return null;
    }

    @Override
    public Boolean deleteById(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public User getOneUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getOneUserById(Long userId) {
        return userRepository.findById(userId);
    }
}