package com.marcusprojeto.projetojpa.resourcers;

import com.marcusprojeto.projetojpa.entities.Category;
import com.marcusprojeto.projetojpa.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorys")
public class CategoryResourcer {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findeALl();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping( value = "/{id}")
    public  ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return  ResponseEntity.ok().body(obj);
    }


}
