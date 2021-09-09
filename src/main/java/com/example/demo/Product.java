package com.example.demo;

import javax.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer price;
    @OneToOne(cascade = {CascadeType.ALL})
    private Payment payment;

    public Product() {
    }

    public Product(Integer id, String name, Integer price, Integer quantity, Payment payment) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.payment = payment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}