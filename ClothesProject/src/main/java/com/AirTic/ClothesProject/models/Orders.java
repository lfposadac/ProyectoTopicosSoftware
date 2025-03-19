package com.AirTic.ClothesProject.models;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int total;
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne
    @JoinColumn(name = "customerClientID", nullable = false)
    private CustomerClients customerClients;
    
    public Orders() {
    }
    
    public Orders(Long id, int total, Date createdAt, Date updatedAt, CustomerClients customerClients) {
        this.id = id;
        this.total = total;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.customerClients = customerClients;
    }
    
    // Getters y setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
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
    
    public CustomerClients getCustomerClients() {
        return customerClients;
    }
    
    public void setCustomerClients(CustomerClients customerClients) {
        this.customerClients = customerClients;
    }
}
