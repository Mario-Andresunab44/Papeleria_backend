package com.papeleriamibarrio.backend.Controllers;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.papeleriamibarrio.backend.Entities.Supplier;
import com.papeleriamibarrio.backend.Services.SupplierServices;

@RestController
@RequestMapping(path = "api/supplier")
public class SupplierController {
   
    @Autowired
    private SupplierServices supplierServices;
    
    @PostMapping
    public ResponseEntity<?> create ( @RequestBody Supplier supplier) {
        return new ResponseEntity<>(supplierServices.create(supplier), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(supplierServices.readAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> readbyId (int id) {
        return new ResponseEntity<>(supplierServices.readById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update (@RequestBody Supplier supplier) {
        return new ResponseEntity<>(supplierServices.update(supplier), HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteById (int id) {
        return new ResponseEntity<>(supplierServices.deleteById(id), HttpStatus.OK);
    }
    
}
