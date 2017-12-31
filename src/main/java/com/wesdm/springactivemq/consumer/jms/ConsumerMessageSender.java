package com.wesdm.springactivemq.consumer.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.wesdm.springactivemq.model.InventoryResponse;

@Component
public class ConsumerMessageSender {

	@Autowired
	JmsTemplate consumerJmsTemplate;

	public void sendMessage(final InventoryResponse inventoryResponse) {
 
    	consumerJmsTemplate.convertAndSend(inventoryResponse);
    	
//				.send((session) -> { return session.createObjectMessage(inventoryResponse);});
    		
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