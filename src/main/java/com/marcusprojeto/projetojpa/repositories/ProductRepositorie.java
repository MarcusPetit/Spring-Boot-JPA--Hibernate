package com.marcusprojeto.projetojpa.repositories;

import com.marcusprojeto.projetojpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositorie extends JpaRepository<Product, Long> {

}
