package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Services {
    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ShopkeeperRepo shopkeeperRepo;
    @Autowired
    ShopRepo shopRepo;

    public List<Shop> getShop(){
        return shopRepo.findAll();
    }
    public Shop getShopById(Integer id) {
        return shopRepo.findById(id).orElse(null);
    }
    public Shopkeeper getShopkeeper(Integer id) {
        Shop shop = getShopById(id);
        return shop.getShopkeeper();
    }
    public List<Product> getProduct(Integer id) {
        Shopkeeper shopkeeper = getShopkeeper(id);
        return shopkeeper.getProduct();
    }
    public Product getProductById(Integer shopId, Integer id) {
        List<Product> products = getProduct(shopId);
        for(Product p : products){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
    public Payment getPayment(Integer shopId, Integer id) {
        Product product = getProductById(shopId, id);
        return product.getPayment();
    }
    public List<Shop> createShop(Shop shop){
        shopRepo.save(shop);
        return shopRepo.findAll();
    }
    public void createShopkeeper(Integer id, Shopkeeper shopkeeper) {
        Shop shop = getShopById(id);
        shop.setShopkeeper(shopkeeper);
        shopkeeperRepo.save(shopkeeper);
    }
    public List<Product> createProduct(Integer id, List<Product> product) {
        Shop shop = getShopById(id );
        Shopkeeper shopKeeper = shop.getShopkeeper();
        List<Product> products = shopKeeper.getProduct();
        products.add(product.get(0));
        shopKeeper.setProduct(products);
        productRepo.saveAll(product);
        return productRepo.findAll();
    }
    public void createPayment(Integer shopId, Integer id, Payment payment) {
        Product product = getProductById(shopId, id);
        product.setPayment(payment);
        paymentRepo.save(payment);
    }
    public void deleteShop(Integer id) {
        shopRepo.deleteById(id);
    }

    public void deleteShopkeeper(Integer id) {
        Shop shop = getShopById(id);
        Shopkeeper shopkeeper = shop.getShopkeeper();
        Integer shopkeeperId = shopkeeper.getId();
        shopkeeperRepo.deleteById(shopkeeperId);
    }

    public void deleteProduct(Integer shopId, Integer id) {
        List<Product> products = getProduct(shopId);
        int index = 0;
        for(Product p : products) {
            if(p.getId().equals(id)) {
                productRepo.deleteById(id);
                products.remove(index);
                productRepo.saveAll(products);
            }
            index++;
        }
        productRepo.deleteById(id);
    }
    public void success(Integer shopId, Integer id) {
        List<Product> products = getProduct(shopId);
        for(Product p : products) {
            if(p.getId().equals(id)){
                p.getPayment().setStatus("success");
                paymentRepo.save(p.getPayment());
                break;
            }
        }
    }
//    public void pending(Integer shopId, Integer id) {
//        List<Product> products = getProduct(shopId);
//        for(Product p : products) {
//            if(p.getId().equals(id)){
//                p.getPayment().setStatus("pending");
//                paymentRepo.save(p.getPayment());
//                break;
//            }
//        }
//    }
}