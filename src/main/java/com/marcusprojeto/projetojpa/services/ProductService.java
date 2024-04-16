package com.marcusprojeto.projetojpa.services;

import com.marcusprojeto.projetojpa.entities.Product;
import com.marcusprojeto.projetojpa.repositories.ProductRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositorie repositorie;

    public List<Product> findeALl(){
        return repositorie.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repositorie.findById(id);
        return obj.get();
    }
}
