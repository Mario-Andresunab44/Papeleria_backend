package com.grupo3.papeleria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo3.papeleria.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
