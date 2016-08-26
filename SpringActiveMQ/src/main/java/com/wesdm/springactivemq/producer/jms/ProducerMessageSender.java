package com.wesdm.springactivemq.producer.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.wesdm.springactivemq.model.Product;

@Component
public class ProducerMessageSender {
 
    @Autowired	
    JmsTemplate producerJmsTemplate;
 
    public void sendMessage(final Product product) {
 
    	producerJmsTemplate.send(new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    ObjectMessage objectMessage = session.createObjectMessage(product);
                    return objectMessage;
                }
            });
    }
 
}
