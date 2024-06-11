package com.yuri.paymentservice.resource;


import com.yuri.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResourceInterface {

	ResponseEntity<Payment> payment(@RequestBody Payment payment);

}
