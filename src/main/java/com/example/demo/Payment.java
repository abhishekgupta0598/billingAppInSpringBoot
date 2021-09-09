package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;
    private Long amount;
    private String status;

    public Payment() {
    }

    public Payment(Long amount, String status, Integer id) {
        this.amount = amount;
        this.status = status;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}