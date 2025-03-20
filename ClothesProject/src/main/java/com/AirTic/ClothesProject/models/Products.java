package com.AirTic.ClothesProject.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    
    // Si deseas guardar la lista de imágenes como una columna en la BD (por ejemplo, serializada en JSON),
    // podrías usar @ElementCollection o alguna estrategia similar. Ajusta según tu requerimiento.
    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_url")
    private List<String> images;
    
    private String size;
    private String color;
    private String material;
    private double price;
    private int stock;
    private String genre;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    private String category;
    private String style;

    public Products() {
    }

    public Products(String name, String description, List<String> images, String size, String color,
                   String material, double price, int stock, String genre, Date createdAt, Date updatedAt,
                   String category, String style) {
        this.name = name;
        this.description = description;
        this.images = images;
        this.size = size;
        this.color = color;
        this.material = material;
        this.price = price;
        this.stock = stock;
        this.genre = genre;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.category = category;
        this.style = style;
    }

    // Getters y Setters

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
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

    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
 
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getGenre() {
        return genre;
    }
 
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
 
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
 
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

    // Manejo automático de fechas
    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
