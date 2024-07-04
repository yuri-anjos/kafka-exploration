package com.yuri.strconsumer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorHandler implements KafkaListenerErrorHandler {

	private final Logger logger = LoggerFactory.getLogger(CustomErrorHandler.class);

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		logger.info("EXCEPTION_HANDLER... ERROR CAPTURED");
		logger.info("Exception: \n{}", exception.getMessage());
		logger.info("Payload: \n{}", message.getPayload());
		logger.info("Headers: \n{}", message.getHeaders());
		logger.info("kafka_offset: {}\n", message.getHeaders().get("kafka_offset"));

		return null;
	}
}
