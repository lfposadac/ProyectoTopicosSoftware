package com.AirTic.ClothesProject.controllers.admin;

import com.AirTic.ClothesProject.models.Product;
import com.AirTic.ClothesProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import java.util.Arrays;
import java.util.List;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/products")
@PreAuthorize("hasRole('ADMIN')")
public class AdminProductController {

    private final ProductService productService;

    private final List<String> availableCategories = Arrays.asList("Shirts", "Shorts");
    private final List<String> availableSizes = Arrays.asList("S", "M", "L", "XL");
    private final List<String> availableColors = Arrays.asList("Red", "Blue", "Green");


    @Autowired
    public AdminProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/new")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("pageTitle", "Create a new product");
        model.addAttribute("formAction", "/admin/products/create");
        model.addAttribute("availableCategories", availableCategories);
        model.addAttribute("availableSizes", availableSizes);
        model.addAttribute("availableColors", availableColors);
        return "admin/product-form";
    }
    // Método para PROCESAR el formulario de creación de nuevo producto
    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("pageTitle", "Crear Nuevo Producto (Corregir Errores)");
            model.addAttribute("formAction", "/admin/products/create");
            model.addAttribute("availableCategories", availableCategories);
            model.addAttribute("availableSizes", availableSizes);
            model.addAttribute("availableColors", availableColors);
            return "admin/product-form";
        }
        try {
            productService.saveProduct(product);
            redirectAttributes.addFlashAttribute("succesMessage", "Product created succesfully.");
            return "redirect:/admin/products/list";
        } catch (Exception e) {
            model.addAttribute("pageTitle", "Crear Nuevo Producto");
            model.addAttribute("formAction", "/admin/products/create");
            model.addAttribute("availableCategories", availableCategories);
            model.addAttribute("availableSizes", availableSizes);
            model.addAttribute("availableColors", availableColors);
            model.addAttribute("errorMessage", "Error al crear el producto: " + e.getMessage());
            return "admin/product-form";
        }
    }
}