package com.example.ProductT.ProductsReadDB;

import com.example.ProductT.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsREAD extends JpaRepository <Product, Long>
{

}
