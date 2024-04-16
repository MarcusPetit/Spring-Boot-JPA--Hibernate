package com.marcusprojeto.projetojpa.repositories;

import com.marcusprojeto.projetojpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositorie extends JpaRepository<Order, Long> {

}
