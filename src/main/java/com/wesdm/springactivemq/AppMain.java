package com.wesdm.springactivemq;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wesdm.springactivemq.model.Product;
import com.wesdm.springactivemq.producer.service.ProductService;

public class AppMain {
    public static void main(String[] args) {
        new Thread(new ProducerApplication()).start();
        new Thread(new ConsumerApplication()).start();
    }

}

class ProducerApplication implements Runnable {
	static final Logger LOG = LoggerFactory.getLogger(ProducerApplication.class);

	private static AtomicInteger id = new AtomicInteger();

	@Override
	public void run() {
	    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		ProductService productService = (ProductService) context.getBean("productService");

		Product product = getProduct();
		LOG.info("Application : sending order {}", product);
		productService.sendProduct(product);

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		((AbstractApplicationContext) context).close();

	}

	private static Product getProduct() {
		Product p = new Product();
		p.setName("Product " + id.incrementAndGet());
		p.setProductId(UUID.randomUUID().toString());
		p.setQuantity(2);
		return p;
	}

}

class ConsumerApplication implements Runnable {
	static final Logger LOG = LoggerFactory.getLogger(ConsumerApplication.class);
	 
	@Override
	public void run() {
	    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        ((AbstractApplicationContext) context).close();
	}
	
}
