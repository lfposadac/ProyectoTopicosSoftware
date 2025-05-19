package com.AirTic.ClothesProject.controllers; // Asegúrate que el paquete sea correcto

import com.AirTic.ClothesProject.models.Product;
import com.AirTic.ClothesProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Arrays;

@Controller
@RequestMapping("/products") // Ruta base para las páginas de productos
public class ProductViewsController {

    private final ProductService productService;
    private final List<String> availableCategories = Arrays.asList("Shirts", "Hoodies", "Shorts", "Pants"); // Ejemplo

    @Autowired
    public ProductViewsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/category/{categoryName}")
    public String showProductsByCategory(@PathVariable String categoryName,
                                        @RequestParam(required = false) String color,
                                        @RequestParam(required = false) String size,
                                        @RequestParam(required = false) Double minPrice,
                                        @RequestParam(required = false) Double maxPrice,
                                        Model model) {

        List<Product> products = productService.getProductsByCategory(categoryName);
        model.addAttribute("pageTitle", categoryName);
        model.addAttribute("currentCategory", categoryName);
        model.addAttribute("products", products);
        model.addAttribute("categoriesForMenu", availableCategories);
        List<String> availableColors = productService.getAvailableColorsForCategory(categoryName);
        List<String> availableSizes = productService.getAvailableSizesForCategory(categoryName);
        model.addAttribute("availableColorsForFilter", availableColors);
        model.addAttribute("availableSizesForFilter", availableSizes);
        model.addAttribute("selectedColor", color);
        model.addAttribute("selectedSize", size);
        model.addAttribute("selectedMinPrice", minPrice);
        model.addAttribute("selectedMaxPrice", maxPrice != null ? maxPrice : 200000.0);

        return "products/products_category";
    }

}