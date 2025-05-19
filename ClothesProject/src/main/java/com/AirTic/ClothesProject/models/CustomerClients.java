package com.AirTic.ClothesProject.models;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "customerclients")
public class CustomerClients {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "customerClients", cascade = CascadeType.ALL)
    private List<Orders> orders;
    
    public CustomerClients(){}

    public CustomerClients(Long id, String name, String email, String password, String role, Date createdAt, Date updatedAt) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.password = password;
      this.role = role;
      this.createdAt = createdAt;
      this.updatedAt = updatedAt;
  }

    // Getters y setters
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
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
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

    public void save(CustomerClients existingAdmin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}