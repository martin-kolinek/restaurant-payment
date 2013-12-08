package org.kolinek.restaurantpayment.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.kolinek.restaurantpayment.Order;
import org.kolinek.restaurantpayment.OrderItem;
import org.kolinek.restaurantpayment.PaymentService;

;

public class Client {
	private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

	public static void main(String args[]) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"client-context.xml");

		PaymentService client = context.getBean("client", PaymentService.class);

		Order ord = new Order();
		ord.getItems().add(new OrderItem(1, 3));
		ord.getItems().add(new OrderItem(2, 3));
		LOGGER.info("order price: {}", client.getPrice(ord));
		client.pay(ord);
		LOGGER.info("order paid");
		context.close();
		System.exit(0);
	}
}
