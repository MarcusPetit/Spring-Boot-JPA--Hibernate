package com.marcusprojeto.projetojpa.services;

import com.marcusprojeto.projetojpa.entities.Category;
import com.marcusprojeto.projetojpa.repositories.CategoryRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepositorie repositorie;

    public List<Category> findeALl(){
        return repositorie.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repositorie.findById(id);
        return obj.get();
    }
}
