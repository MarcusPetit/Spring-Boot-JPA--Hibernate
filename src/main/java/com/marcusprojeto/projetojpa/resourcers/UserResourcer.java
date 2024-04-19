package com.marcusprojeto.projetojpa.resourcers;

import com.marcusprojeto.projetojpa.entities.User;
import com.marcusprojeto.projetojpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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


    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }




}
