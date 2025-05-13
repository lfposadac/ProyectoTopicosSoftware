package com.AirTic.ClothesProject.controllers;

import com.AirTic.ClothesProject.models.Products;
import com.AirTic.ClothesProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController.java {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String listProducts(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products)
        return "products/produtcs_list";
    }

    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable Long id, MOdel model) {
        Product product = productService.getProductById(id).orElseThrow(() -> new IllegalArgumentException("Product with id "+id+" not found"));
        model.addAttribute("product", product);
        return "products/unique_product_detail";
    }

    

}