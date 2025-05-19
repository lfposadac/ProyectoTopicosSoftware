package com.AirTic.ClothesProject.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.AirTic.ClothesProject.models.CustomerClients;
import com.AirTic.ClothesProject.repositories.CustomerClientsRepository;
import com.AirTic.ClothesProject.services.CustomerClientsService;

@Component
public class AdminUserInitializer implements CommandLineRunner {
    
    @Autowired
    private CustomerClientsService customerClientsService;

    @Autowired
    private CustomerClientsRepository customerClientsRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Value("${app.admin.email:admin@example.com}")
    private String adminEmail;

    @Value("${app.admin.password:adminpass}")
    private String adminPassword;

    @Value("${app.admin.name:Admin User}")
    private String adminName;

    private final String ADMIN_ROLE_NAME = "ROLE_ADMIN";
    private final String USER_ROLE_NAME = "ROLE_USER";

    @Override
    public void run(String... args) throws Exception {
        CustomerClients existingAdmin = customerClientsService.findByEmail(adminEmail);
        if(existingAdmin == null){
            CustomerClients adminCustomer = new CustomerClients();
            adminCustomer.setName(adminName);
            adminCustomer.setEmail(adminEmail);
            adminCustomer.setPassword(adminPassword);
            adminCustomer.setRole(ADMIN_ROLE_NAME);
            adminCustomer.setCreatedAt(new Date());
            adminCustomer.setUpdatedAt(new Date());

            try {
                customerClientsService.registerCustomer(adminCustomer);
                System.out.println("Admin user created successfully.");
            } catch (RuntimeException e) {
                System.err.println("Error creating admin user: " + e.getMessage());
            }
        } else{
            if (existingAdmin.getRole() == null || !existingAdmin.getRole().equals(ADMIN_ROLE_NAME)) {
                String currentRole = existingAdmin.getRole();
                if(currentRole == null || currentRole.isEmpty() || !currentRole.equals(ADMIN_ROLE_NAME)){
                    if(currentRole != null && currentRole.contains(USER_ROLE_NAME) && !currentRole.contains(ADMIN_ROLE_NAME)) {
                        existingAdmin.setRole(currentRole + ", " + ADMIN_ROLE_NAME);
                    } else{
                        existingAdmin.setRole(ADMIN_ROLE_NAME);
                    }
                    existingAdmin.setUpdatedAt(new Date());
                    customerClientsRepository.save(existingAdmin);
                    System.out.println("Admin role updated successfully.");
                } else {
                    System.out.println("Admin user already exists.");
                }
        
            } else {
                System.out.println("Admin user already exists.");
            }
        }
    }
}
