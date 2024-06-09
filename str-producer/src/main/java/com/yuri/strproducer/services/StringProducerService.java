package com.yuri.strproducer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class StringProducerService {

	private final Logger logger = LoggerFactory.getLogger(StringProducerService.class);
	private final KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	public StringProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		kafkaTemplate.send("str-topic", message).whenComplete((result, e) -> {
			if (e == null) {
				logger.info("Send message successfully!");
				logger.info("Partition: {}", result.getRecordMetadata().partition());
				logger.info("Offset: {}", result.getRecordMetadata().offset());
			} else {
				logger.error("Error sending message: {}", e.getMessage());
			}
		});
	}
}
