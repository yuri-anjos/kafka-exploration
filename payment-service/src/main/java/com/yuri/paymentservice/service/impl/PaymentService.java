package com.yuri.paymentservice.service.impl;

import com.yuri.paymentservice.model.Payment;
import com.yuri.paymentservice.service.PaymentServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class PaymentService implements PaymentServiceInterface {

	private final Logger logger = LoggerFactory.getLogger(PaymentService.class);

	private final KafkaTemplate<String, Serializable> kafkaTemplate;

	@Autowired
	public PaymentService(KafkaTemplate<String, Serializable> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void sendPayment(Payment payment) throws InterruptedException {
		logger.info("Payment received: {}", payment);
		Thread.sleep(1000);

		logger.info("Sending payment...");
		kafkaTemplate.send("payment-topic", payment);
	}
}
