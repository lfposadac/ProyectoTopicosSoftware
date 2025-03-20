package com.AirTic.ClothesProject.repositories;

import com.AirTic.ClothesProject.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
    
}
