package com.wesdm.springactivemq.producer.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.wesdm.springactivemq.model.InventoryResponse;

@Component
public class ProducerMessageReceiver implements MessageListener{
 
    static final Logger LOG = LoggerFactory.getLogger(ProducerMessageReceiver.class);
     
    @Autowired
    MessageConverter messageConverter;
     
    @Override
    public void onMessage(Message message) {
        try {
            LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
            InventoryResponse response = (InventoryResponse) messageConverter.fromMessage(message);
            LOG.info("Application : order response received : {}",response);    
            LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
}
