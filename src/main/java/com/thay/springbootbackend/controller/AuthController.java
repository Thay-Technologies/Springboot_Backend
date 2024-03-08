package com.thay.springbootbackend.controller;

import com.thay.springbootbackend.dto.UserDto;
import com.thay.springbootbackend.security.JwtTokenProvider;
import com.thay.springbootbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    final AuthenticationManager authenticationManager;

    final JwtTokenProvider jwtTokenProvider;

    final UserService userService;

    final PasswordEncoder passwordEncoder;


    public AuthController(AuthenticationManager authenticationManager, UserService userService,
                          PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;

    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){

        String password = userDto.getPassword();
        String username = userDto.getUsername();

        if (password == null || password.isEmpty() ) {
            throw new IllegalArgumentException("Şifre boş olamaz.");
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( username, password);
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);

        return "Bearer " + jwtToken;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {

        String username = userDto.getUsername();
        String password = userDto.getPassword();

        if (username == null || username.isEmpty()) {
            return new ResponseEntity<>("Username cannot be null or empty", HttpStatus.BAD_REQUEST);
        }

        if (password == null || password.isEmpty()) {
            return new ResponseEntity<>("Password cannot be null or empty", HttpStatus.BAD_REQUEST);
        }

        // Set the username and encode the password
        userDto.setUsername(username);
        userDto.setPassword(passwordEncoder.encode(password));

        // Check if the username is already in use
        if (userService.getOneUserByName(username) != null) {
            return new ResponseEntity<>("Username is already in use", HttpStatus.BAD_REQUEST);
        }

        // Save the user
        userService.createNewUser(userDto);

        return new ResponseEntity<>("User successfully registered", HttpStatus.CREATED);
    }
}
