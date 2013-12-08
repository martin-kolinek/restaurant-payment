package org.kolinek.restaurantpayment;

import java.math.BigDecimal;

import javax.jws.WebService;

@WebService
public interface PaymentService {
	BigDecimal getPrice(Order ord);

	void pay(Order ord);
}
