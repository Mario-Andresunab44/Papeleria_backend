package com.papeleriamibarrio.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.papeleriamibarrio.backend.Entities.Supplier;

import Repositories.SupplierRepository;
import net.bytebuddy.asm.Advice.Return;

@Service
public class SupplierServices {
    
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> readAll(){
        return supplierRepository.findAll();
    }


    public Supplier create(Supplier supplier){
        if (supplierRepository.existsById(supplier.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Supplier already exists");
        if (SupplierRepository.existsByName(supplier.getName()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The Supplier already exists");
        return supplierRepository.save(supplier);
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier readById(int Id) {
        return supplierRepository.findById(Id)
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "This Supplier does not exists"));
    }

    public Supplier update(Supplier supplier) {
        Optional<Supplier> byName = supplierRepository.findByName(supplier.getName());
        if (byName.isPresent() && byName.get().getId() == supplier.getId())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "The Supplier already exists");
        Supplier previous = readById(supplier.getId());
        supplierRepository.save(supplier);
        return previous;
    }

    public Supplier deleteById(int id){
        Supplier previous = readById(id);
        supplierRepository.delete(previous);
        return previous;
    }
}
