package com.marcusprojeto.projetojpa.repositories;

import com.marcusprojeto.projetojpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorie extends JpaRepository<User , Long> {

}
