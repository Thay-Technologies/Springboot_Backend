package com.thay.springbootbackend.service.impl;

import com.thay.springbootbackend.entity.User;
import com.thay.springbootbackend.repository.UserRepository;
import com.thay.springbootbackend.security.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username);
        return JwtUserDetails.create(user);

    }
    public UserDetails loadUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.map(JwtUserDetails::create).orElse(null);
    }
}
