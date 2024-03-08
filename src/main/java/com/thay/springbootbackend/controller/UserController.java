package com.thay.springbootbackend.controller;

import com.thay.springbootbackend.dto.UserDto;
import com.thay.springbootbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getOneUser(@PathVariable Long userId){

        UserDto userDto = userService.getOneUser(userId);

        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto newUser){
        return ResponseEntity.ok(userService.createNewUser(newUser));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateOneUser(@PathVariable Long userId, @RequestBody UserDto newUser){
        return ResponseEntity.ok(userService.updateOneUser(userId, newUser));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Boolean>deleteOneUser(@PathVariable Long userId){
        Boolean status = userService.deleteById(userId);
        return ResponseEntity.ok(status);
    }

}
