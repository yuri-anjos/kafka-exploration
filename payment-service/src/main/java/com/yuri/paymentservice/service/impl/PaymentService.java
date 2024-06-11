package com.yuri.paymentservice.service.impl;

import com.yuri.paymentservice.model.Payment;
import com.yuri.paymentservice.service.PaymentServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements PaymentServiceInterface {

	private final Logger logger = LoggerFactory.getLogger(PaymentService.class);

	@Override
	public void sendPayment(Payment payment) {
		logger.info("Payment received: {}", payment.toString());
	}
}
