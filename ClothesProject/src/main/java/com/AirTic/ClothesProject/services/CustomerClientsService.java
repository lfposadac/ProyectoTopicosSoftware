package com.AirTic.ClothesProject.services;

import com.AirTic.ClothesProject.models.CustomerClients;
import com.AirTic.ClothesProject.repositories.CustomerClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerClientsService {

    @Autowired
    private CustomerClientsRepository customerClientsRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public CustomerClients registerCustomer(CustomerClients customer) {
        // Verificar si el email ya existe
        if(customerClientsRepository.findByEmail(customer.getEmail()) != null) {
            throw new RuntimeException("El email ya está en uso");
        }
        
        // Encriptar la contraseña
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        
        // Guardar el cliente en la base de datos
        return customerClientsRepository.save(customer);
    }

    public CustomerClients findByEmail(String adminEmail) {
        return customerClientsRepository.findByEmail(adminEmail);
    }
}