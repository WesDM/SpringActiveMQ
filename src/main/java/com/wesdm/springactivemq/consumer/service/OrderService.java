package com.wesdm.springactivemq.consumer.service;

import com.wesdm.springactivemq.model.Product;

public interface OrderService { 
    public void processOrder(Product product);
}
