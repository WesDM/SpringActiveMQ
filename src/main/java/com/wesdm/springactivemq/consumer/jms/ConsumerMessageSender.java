package com.wesdm.springactivemq.consumer.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.wesdm.springactivemq.model.InventoryResponse;

@Component
public class ConsumerMessageSender {

	@Autowired
	JmsTemplate consumerJmsTemplate;

	public void sendMessage(final InventoryResponse inventoryResponse) {
 
    	consumerJmsTemplate.send((session) -> { return session.createObjectMessage(inventoryResponse);});
    		
//    			
//    			new MessageCreator(){
//                @Override
//                public Message createMessage(Session session) throws JMSException{
//                    ObjectMessage objectMessage = session.createObjectMessage(inventoryResponse);
//                    return objectMessage;
//                }
//            });
    }

}