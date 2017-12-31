package com.wesdm.springactivemq.producer.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.wesdm.springactivemq.model.Product;

@Component
public class ProducerMessageSender {
 
    @Autowired	
    JmsTemplate producerJmsTemplate;
 
    public void sendMessage(final Product product) {
 
    	producerJmsTemplate.convertAndSend(product);
    	
    	
//    	.send(new MessageCreator(){
//                @Override
//                public Message createMessage(Session session) throws JMSException{
//                    ObjectMessage objectMessage = session.createObjectMessage(product);
//                    return objectMessage;
//                }
//            });
    }
 
}
