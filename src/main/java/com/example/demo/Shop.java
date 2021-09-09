package com.example.demo;
import javax.persistence.*;

@Entity
public class Shop {
    @Id
    private Integer shopId;
    private String shopName;
    private String address;
    @OneToOne(cascade = {CascadeType.ALL})
    private Shopkeeper shopkeeper;

    public Shop() {

    }
    public Shop(Integer shopId, String shopName, String address, Shopkeeper shopkeeper) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.address = address;
        this.shopkeeper = shopkeeper;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Shopkeeper getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(Shopkeeper shopkeeper) {
        this.shopkeeper = shopkeeper;
    }
}