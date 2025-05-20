package com.AirTic.ClothesProject.services;

import com.AirTic.ClothesProject.models.CustomerClients;
import com.AirTic.ClothesProject.repositories.CustomerClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerClientsService {

    @Autowired
    private CustomerClientsRepository customerClientsRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final String DEFAULT_USER_ROLE = "ROLE_USER";
    
    public CustomerClients registerCustomer(CustomerClients customer) {
        if (customerClientsRepository.findByEmail(customer.getEmail()) != null) {
            if (customer.getId() == null && customerClientsRepository.findByEmail(customer.getEmail()) != null) {
                 throw new RuntimeException("Email is already in use: " + customer.getEmail());
            }
        }
        if (customer.getPassword() != null && !customer.getPassword().startsWith("$2a$")) {
             customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        }
        if (customer.getRole() == null || customer.getRole().isEmpty()) {
            customer.setRole(DEFAULT_USER_ROLE);
        }
        return customerClientsRepository.save(customer);
    }

    public CustomerClients findByEmail(String adminEmail) {
        return customerClientsRepository.findByEmail(adminEmail);
    }
}