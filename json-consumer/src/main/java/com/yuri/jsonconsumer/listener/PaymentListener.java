package com.yuri.jsonconsumer.listener;

import com.yuri.jsonconsumer.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class PaymentListener {

	private final Logger logger = LoggerFactory.getLogger(PaymentListener.class);

	@KafkaListener(topics = "payment-topic", groupId = "anti-fraud-group", containerFactory = "jsonContainerFactory")
	public void validateAntiFraud(@Payload Payment payment) {
		logger.info("Payment received: {}", payment);
		logger.info("Validating payment...");
		logger.info("Payment approved!");
	}

	@KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void generatePdfFile(@Payload Payment payment) {
		var formatter = DateTimeFormatter.ofPattern("yyyyMMdd:HHmmss");
		var formattedDate = LocalDateTime.now().format(formatter);
		var filename = payment.getId() + "_" + formattedDate;
		logger.info("Generating PDF file: {}", filename);
	}

	@KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendEmail(@Payload Payment payment) {
		logger.info("Sending email to user: {}", payment.getUserId());
	}
}
