package com.marcusprojeto.projetojpa.config;

import com.marcusprojeto.projetojpa.entities.*;
import com.marcusprojeto.projetojpa.entities.enums.OrdersStatus;
import com.marcusprojeto.projetojpa.repositories.*;
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

    @Autowired
    private CategoryRepositorie categoryRepositorie;

    @Autowired
    private ProductRepositorie productRepositorie;

    @Autowired
    private OrderItemsRepositorie orderItemsRepositorie;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepositorie.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
        categoryRepositorie.saveAll(Arrays.asList(cat1, cat2,cat3));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);
        productRepositorie.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User(null, "Maria Brown", "maria@hotmail.com", "83774774" , "1234556");
        User u2 = new User(null, "Alex Nadal", "alex@hotmail.com", "994747383" , "1234556");
        User u3 = new User(null, "Caio Mando", "caio@hotmail.com", "99422222" , "1234556");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrdersStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrdersStatus.WAITTING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrdersStatus.WAITTING_PAYMENT, u1);


        userRepositorie.saveAll(Arrays.asList(u1,u2,u3));
        orderRepositorie.saveAll(Arrays.asList(o1,o2,o3));

        OrderItem oi1 = new OrderItem(o1, p1, p1.getPrice(), 2);
        OrderItem oi2 = new OrderItem(o1, p3, p3.getPrice(), 1);
        OrderItem oi3 = new OrderItem(o2, p3, p3.getPrice(), 2);
        OrderItem oi4 = new OrderItem(o3, p5, p5.getPrice(), 2);

        orderItemsRepositorie.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-07-22T15:21:22Z"), o1);
        o1.setPayment(pay1);
        orderRepositorie.save(o1);
    }
}
