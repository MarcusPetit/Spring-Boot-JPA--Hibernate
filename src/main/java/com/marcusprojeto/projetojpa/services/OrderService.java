package com.marcusprojeto.projetojpa.services;

import com.marcusprojeto.projetojpa.entities.Order;
import com.marcusprojeto.projetojpa.entities.User;
import com.marcusprojeto.projetojpa.repositories.OrderRepositorie;
import com.marcusprojeto.projetojpa.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepositorie repositorie;

    public List<Order> findeALl(){
        return repositorie.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repositorie.findById(id);
        return obj.get();
    }
}
