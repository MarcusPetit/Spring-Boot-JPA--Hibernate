package com.marcusprojeto.projetojpa.resourcers;

import com.marcusprojeto.projetojpa.entities.User;
import com.marcusprojeto.projetojpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResourcer {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findeALl();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping( value = "/{id}")
    public  ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return  ResponseEntity.ok().body(obj);
    }


}
