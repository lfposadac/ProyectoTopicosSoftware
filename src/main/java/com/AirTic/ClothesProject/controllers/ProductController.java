package com.AirTic.ClothesProject.controllers;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.AirTic.ClothesProject.models.Products;
import com.AirTic.ClothesProject.repositories.ProductRepository;
import java.util.List;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String indexProducts(Model model) {
        List<Products> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products/showlist";
    }

    @GetMapping("/products/{id}")
    public String showProducts(@PathVariable("id") Long id, Model model) {
        Products products = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        model.addAttribute("title", products.getCategory());
        model.addAttribute("subtitle", products.getName());
        model.addAttribute("product", products);
        return "products/show";
    }

    @GetMapping("/products/create")
    public String createProduct(Model model) {
        model.addAttribute("products", new Products());
        return "products/create";
    }

    @PostMapping("/products")
    public String saveProduct(Products products, RedirectAttributes redirectAttributes) {
        if (products.getName() == null || products.getName().trim().isEmpty() ||
            products.getDescription() == null || products.getDescription().trim().isEmpty() ||
            products.getSize() == null || products.getSize().trim().isEmpty() ||
            products.getColor() == null || products.getColor().trim().isEmpty() ||
            products.getMaterial() == null || products.getMaterial().trim().isEmpty() ||
            products.getPrice() <= 0 ||
            products.getStock() < 0 ||
            products.getGenre() == null || products.getGenre().trim().isEmpty() ||
            products.getCategory() == null || products.getCategory().trim().isEmpty() ||
            products.getStyle() == null || products.getStyle().trim().isEmpty()) {
            
            throw new RuntimeException("Please fill in all required product fields");
        }
        
        productRepository.save(products);
        
        redirectAttributes.addFlashAttribute("message", "The product was created successfully!");
        return "redirect:/products";
    }
    
}
