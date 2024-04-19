package com.marcusprojeto.projetojpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcusprojeto.projetojpa.entities.pk.OrdemItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem  {
    @EmbeddedId
    private OrdemItemPK id = new OrdemItemPK();

    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Double price, Integer quantity) {
        id.setOrder(order);
        id.setProduct(product);
        this.price = price;
        this.quantity = quantity;
        
    }
    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    public void setOrder(Order order){

        id.setOrder(order);
    }


    public Product getProduct(){

        return id.getProduct();
    }
    public void setProduct(Product product){

        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubTotal(){
        return  price * quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
