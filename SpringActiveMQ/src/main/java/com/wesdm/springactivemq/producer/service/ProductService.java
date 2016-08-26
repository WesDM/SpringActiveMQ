package com.wesdm.springactivemq.producer.service;

import com.wesdm.springactivemq.model.Product;

public interface ProductService {
    public void sendProduct(Product product);
}