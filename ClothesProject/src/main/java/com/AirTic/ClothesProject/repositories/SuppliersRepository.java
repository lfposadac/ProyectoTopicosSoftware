package com.AirTic.ClothesProject.repositories;

import com.AirTic.ClothesProject.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Long>{
}
