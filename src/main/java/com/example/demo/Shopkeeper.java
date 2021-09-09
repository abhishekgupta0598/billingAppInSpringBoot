package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shopkeeper {
    @Id
    @GeneratedValue
    private Integer id;
    private Long mobile_no;
    private String name;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Product> product;

    public Shopkeeper() {
    }

    public Shopkeeper(String name, Long mobile_no, List<Product> product) {
        this.name = name;
        this.mobile_no = mobile_no;
        this.product = product;
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

    public Long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

}