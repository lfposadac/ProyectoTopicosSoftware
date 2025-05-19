package com.AirTic.ClothesProject.models;
import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    @Column(nullable = false)
    private String name;

    @Size(max = 1000, message = "Description must be less than 1000 characters")
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private String imageUrl;

    @Column(name="size_options")
    private String size;

    private String color;
    private String material;


    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Column(nullable = false)
    private Double price;

    @Min(value = 0, message = "Stock must be greater than 0")
    private Integer stock;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Style is required")
    private String style;

    
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Product() {
    }
    
    public Product(String name, String description, String imageUrl, String size, String color, String material, Double price, Integer stock, String category, String style) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.size = size;
        this.color = color;
        this.material = material;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.style = style;
    }

    /* GETTER Y SETTERS */ 
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    /* MANEJO DE FECHAS */
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
        updatedAt = LocalDate.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }

}
