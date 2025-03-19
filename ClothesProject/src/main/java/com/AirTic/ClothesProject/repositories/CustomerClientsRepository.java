package com.AirTic.ClothesProject.repositories;

import com.AirTic.ClothesProject.models.CustomerClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CustomerClientsRepository extends JpaRepository<CustomerClients, Long> {
    // Cambia findByUsername por findByEmail
    Optional<CustomerClients> findByEmail(String email);
}