package com.marcusprojeto.projetojpa.repositories;

import com.marcusprojeto.projetojpa.entities.Category;
import com.marcusprojeto.projetojpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositorie extends JpaRepository<Category, Long> {

}
