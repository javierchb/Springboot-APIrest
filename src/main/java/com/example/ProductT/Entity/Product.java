package com.example.ProductT.Entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name",nullable = false, length = 30)
    private String name;

    public Long getId(){
      return id;
    }
    public void setId(Long id){
      this.id = id;
    }
    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }
}
