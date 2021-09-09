package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class Controller {

    @Autowired
    Services services;

    @GetMapping("/getShop")
    public List<Shop> getShop() {
        return services.getShop();
    }
    @GetMapping("/getShopById/{id}")
    public Shop getShopById(@PathVariable Integer id) {
        return services.getShopById(id);
    }
    @GetMapping("/getShopById/{shopId}/shopkeeper")
    public Shopkeeper getShopKeeper(@PathVariable Integer shopId) {
        return services.getShopkeeper(shopId);
    }
    @GetMapping("/getShopById/{shopId}/shopkeeper/getProduct")
    public List<Product> getProduct(@PathVariable Integer shopId) {
        return services.getProduct(shopId);
    }
    @GetMapping("/getShopById/{shopId}/shopkeeper/getProductById/{id}")
    public Product getProductById(@PathVariable Integer shopId, @PathVariable Integer id) {
        return services.getProductById(shopId, id);
    }
    @GetMapping("/getShopById/{shopId}/shopkeeper/getProduct/{id}")
    public Payment getPayment(@PathVariable Integer shopId, @PathVariable Integer id) {
        return services.getPayment(shopId, id);
    }
    @PostMapping("/createShop")
    public List<Shop> createShop(@RequestBody Shop shop) {
        return services.createShop(shop);
    }
    @PostMapping("/getShopById/{shopId}/createShopkeeper")
    public void createShopkeeper(@PathVariable Integer shopId, @RequestBody Shopkeeper shopkeeper) {
        services.createShopkeeper(shopId, shopkeeper);
    }
    @PostMapping("/getShopById/{shopId}/shopkeeper/product")
    public List<Product> createProduct(@PathVariable Integer shopId, @RequestBody List<Product> product) {
        return services.createProduct(shopId, product);
    }
    @PostMapping("/getShopById/{shopId}/shopkeeper/product/{id}")
    public void createPayment(@PathVariable Integer shopId, @PathVariable Integer id, @RequestBody Payment payment) {
        services.createPayment(shopId,id, payment);
    }
    @DeleteMapping("/deleteShop/{id}")
    public void deleteShop(@PathVariable Integer id) {
        services.deleteShop(id);
    }
    @DeleteMapping("/getShop/{id}/deleteShopkeeper")
    public void deleteShopkeeper(@PathVariable Integer id) {
        services.deleteShopkeeper(id);
    }
    @DeleteMapping("/getShop/{shopId}/shopkeeper/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer shopId, @PathVariable Integer id) {
        services.deleteProduct(shopId, id);
    }
    @PutMapping("/getShop/{shopId}/shopkeeper/product/{id}/status/success")
    public void success(@PathVariable Integer shopId, @PathVariable Integer id) {
        services.success(shopId, id);
    }
//    @PutMapping("/getShop/{shopId}/shopkeeper/product/{id}/status/pending")
//    public void pending(@PathVariable Integer shopId, @PathVariable Integer id) {
//        services.pending(shopId, id);
//    }
}