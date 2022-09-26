package com.flightapp.services;

import com.flightapp.entity.LoginDetails;
import com.flightapp.exception.AuthenticationException;
import com.flightapp.repository.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginDetailsService {
    @Autowired
    LoginDetailsRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public LoginDetails getByUsername(String username){
        return repository.findByUserName(username);
    }
    public LoginDetails createUser(LoginDetails details) throws AuthenticationException {
        if(repository.findByUserName(details.getUserName()) != null){
            throw new AuthenticationException("User Already available");
        }
        details.setPassword(passwordEncoder.encode(details.getPassword()));
        return repository.save(details);
    }
}
