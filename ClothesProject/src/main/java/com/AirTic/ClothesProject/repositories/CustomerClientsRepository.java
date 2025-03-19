package com.AirTic.ClothesProject.repositories;

import com.AirTic.ClothesProject.models.CustomerClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerClientsRepository extends JpaRepository<CustomerClients, Long> {
    CustomerClients findByEmail(String email);
}