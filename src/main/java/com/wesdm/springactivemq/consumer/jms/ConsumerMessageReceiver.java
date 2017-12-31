package com.wesdm.springactivemq.consumer.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.wesdm.springactivemq.consumer.service.OrderService;
import com.wesdm.springactivemq.model.Product;

/**
 * Message driven listener
 * @author Wesley
 *
 */
@Component
public class ConsumerMessageReceiver implements MessageListener {

	static final Logger LOG = LoggerFactory.getLogger(ConsumerMessageReceiver.class);

	@Autowired
	MessageConverter messageConverter;

	@Autowired
	OrderService orderService;

	@Override
	public void onMessage(Message message) {
		if (message instanceof ObjectMessage) {
			try {
				LOG.info("-----------------------------------------------------");
				// Product product = (Product) messageConverter.fromMessage(message);
				Product product = (Product) ((ObjectMessage) message).getObject();

				LOG.info("Application : order received : {}", product);
				orderService.processOrder(product);
				LOG.info("-----------------------------------------------------");
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("Message must be of type ObjectMessage");
		}

	}
}
