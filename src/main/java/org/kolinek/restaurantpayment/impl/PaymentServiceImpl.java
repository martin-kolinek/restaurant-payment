package org.kolinek.restaurantpayment.impl;

import java.math.BigDecimal;

import org.kolinek.restaurantpayment.Order;
import org.kolinek.restaurantpayment.OrderItem;
import org.kolinek.restaurantpayment.PaymentService;

public class PaymentServiceImpl implements PaymentService {

	@Override
	public BigDecimal getPrice(Order ord) {
		BigDecimal result = new BigDecimal(0);
		for(OrderItem i:ord.getItems()) {
			result = result.add(new BigDecimal(i.getQuantity() * 10));
		}
		return result;
	}

	@Override
	public void pay(Order ord) {
		//nothing
	}
	
}
