package com.yuri.strconsumer.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StrConsumerListener {

	private final Logger logger = LoggerFactory.getLogger(StrConsumerListener.class);

	@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
	public void create(String message) {
		logger.info("CREATE ::: Receive message \n{}", message);
	}

	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
	public void log(String message) {
		logger.info("LOG ::: Receive message \n{}", message);
	}

	@KafkaListener(groupId = "group-3", topics = "str-topic", containerFactory = "strContainerFactory")
	public void email(String message) {
		logger.info("Email ::: Receive message \n{}", message);
	}
}
