package com.marcusprojeto.projetojpa.config;

import com.marcusprojeto.projetojpa.entities.Order;
import com.marcusprojeto.projetojpa.entities.User;
import com.marcusprojeto.projetojpa.repositories.OrderRepositorie;
import com.marcusprojeto.projetojpa.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {


    @Autowired
    private UserRepositorie userRepositorie;

    @Autowired
    private OrderRepositorie orderRepositorie;

    @Override
    public void run(String... args) throws Exception {
       User u1 = new User(null, "Maria Brown", "maria@hotmail.com", "83774774" , "1234556");
       User u2 = new User(null, "Alex Nadal", "alex@hotmail.com", "994747383" , "1234556");
       User u3 = new User(null, "Caio Mando", "caio@hotmail.com", "99422222" , "1234556");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

       userRepositorie.saveAll(Arrays.asList(u1,u2,u3));
       orderRepositorie.saveAll(Arrays.asList(o1,o2,o3));

    }
}
