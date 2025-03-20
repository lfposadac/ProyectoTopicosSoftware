package com.AirTic.ClothesProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AirTic.ClothesProject.models.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long>{
    
}
