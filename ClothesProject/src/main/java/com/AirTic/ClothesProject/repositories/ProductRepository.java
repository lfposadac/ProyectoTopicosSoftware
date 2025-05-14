package com.AirTic.ClothesProject.repositories;

import com.AirTic.ClothesProject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByPriceLessThan(Double price);
}

/* METODOS HEREDADOS DE JPA:
 * void delete(T entity): Elimina una entidad dada. (Este es el que estás usando).
 * void deleteById(ID id): Elimina la entidad con el ID dado.
 * void deleteAll(): Elimina todas las entidades gestionadas por el repositorio.
 * void deleteAll(Iterable<? extends T> entities): Elimina las entidades dadas.
 * void deleteAllById(Iterable<? extends ID> ids): Elimina todas las entidades con los IDs dados.
 */