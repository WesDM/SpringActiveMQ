package com.wesdm.springactivemq.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesdm.springactivemq.consumer.jms.ConsumerMessageSender;
import com.wesdm.springactivemq.model.InventoryResponse;
import com.wesdm.springactivemq.model.Product;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
 
    static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);
     
    @Autowired
    ConsumerMessageSender messageSender;
     
    @Override
    public void processOrder(Product product) {
         
        InventoryResponse response = prepareResponse(product);
        LOG.info("Inventory : sending order confirmation {}", response);
        messageSender.sendMessage(response);
    }
     
    private InventoryResponse prepareResponse(Product product){
        InventoryResponse response = new InventoryResponse();
        response.setProductId(product.getProductId());
        response.setReturnCode(200);
        response.setComment("Order Processed successfully");
        return response;
    }
 
     
     
}
