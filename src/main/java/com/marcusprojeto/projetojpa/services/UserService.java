package com.marcusprojeto.projetojpa.services;

import com.marcusprojeto.projetojpa.entities.User;
import com.marcusprojeto.projetojpa.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepositorie repositorie;

    public List<User> findeALl(){
        return repositorie.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repositorie.findById(id);
        return obj.get();
    }
    public User insert (User obj){
        return repositorie.save(obj);
    }
}
