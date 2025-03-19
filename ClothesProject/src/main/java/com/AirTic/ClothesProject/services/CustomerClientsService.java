package com.AirTic.ClothesProject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.AirTic.ClothesProject.models.CustomerClients;
import com.AirTic.ClothesProject.repositories.CustomerClientsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerClientsService implements UserDetailsService {
    
    @Autowired
    private CustomerClientsRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomerClients> user = repository.findByEmail(username);
        if(user.isPresent()) {
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getEmail()) 
                    .password(userObj.getPassword())
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}