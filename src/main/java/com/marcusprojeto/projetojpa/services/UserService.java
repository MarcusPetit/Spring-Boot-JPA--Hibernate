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

    public void delete (Long id){
        repositorie.deleteById(id);
    }

    public User update(Long id , User obj){
        User entity = repositorie.getReferenceById(id);
        updateData(entity , obj);
        return repositorie.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone((obj.getPhone()));
    }
}
