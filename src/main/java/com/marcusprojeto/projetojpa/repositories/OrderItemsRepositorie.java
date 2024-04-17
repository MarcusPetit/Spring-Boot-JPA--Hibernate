package com.marcusprojeto.projetojpa.repositories;

import com.marcusprojeto.projetojpa.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepositorie extends JpaRepository<OrderItem, Long> {

}
