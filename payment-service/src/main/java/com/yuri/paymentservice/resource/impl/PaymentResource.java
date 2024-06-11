package com.yuri.paymentservice.resource.impl;

import com.yuri.paymentservice.model.Payment;
import com.yuri.paymentservice.resource.PaymentResourceInterface;
import com.yuri.paymentservice.service.PaymentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentResource implements PaymentResourceInterface {

	private final PaymentServiceInterface paymentService;

	@Autowired
	public PaymentResource(PaymentServiceInterface paymentService) {
		this.paymentService = paymentService;
	}

	@Override
	@PostMapping
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
