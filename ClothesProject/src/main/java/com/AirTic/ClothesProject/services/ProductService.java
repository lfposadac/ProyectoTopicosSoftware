package com.AirTic.ClothesProject.services;

import com.AirTic.ClothesProject.models.Products;
import com.AirTic.ClothesProject.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Products> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public Products saveProduct(Products product) {
        return productRepository.save(product);
    }
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        product.setImageUrl(productDetails.getImageUrl());
        product.setSize(productDetails.getSize());
        product.setColor(productDetails.getColor());
        product.setMaterial(productDetails.getMaterial());
        product.setCategory(productDetails.getCategory());
        product.setStyle(productDetails.getStyle());

        return ProductRepository.save(product);
    }
}
