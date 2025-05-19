package com.AirTic.ClothesProject.services;

import com.AirTic.ClothesProject.models.Product;
import com.AirTic.ClothesProject.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public Product saveProduct(Product product) {
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

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        productRepository.delete(product);
    }

    public List<String> getAvailableColorsForCategory(String categoryName){
        List<Product> products = productRepository.findByCategory(categoryName);
        return products.stream()
                .map(Product::getColor)
                .distinct()
                .toList();
    }

    public List<String> getAvailableSizesForCategory(String categoryName) {
        List<Product> products = productRepository.findByCategory(categoryName);
        return products.stream()
                .map(Product::getSize)
                .distinct()
                .toList();
    }
}
