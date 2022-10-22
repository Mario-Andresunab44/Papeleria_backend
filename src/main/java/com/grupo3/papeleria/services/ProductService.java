package com.grupo3.papeleria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.grupo3.papeleria.entities.Product;
import com.grupo3.papeleria.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public Product create(Product product) {
        if (productRepository.existsById(product.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Product already exists");
        return productRepository.save(product);
    }

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public Product readById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product does not exists"));
    }

    public Product update(Product product) {
        Product target = readById(product.getId());
        productRepository.save(product);
        return target;
    }

    public void deleteById(int id) {
        productRepository.delete(readById(id));
    }

}
