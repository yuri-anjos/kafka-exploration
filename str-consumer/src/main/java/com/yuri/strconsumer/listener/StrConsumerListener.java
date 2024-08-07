package com.yuri.strconsumer.listener;

import com.yuri.strconsumer.custom.StrConsumerCustomListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StrConsumerListener {

	private final Logger logger = LoggerFactory.getLogger(StrConsumerListener.class);

//	@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory",
//			topicPartitions = {
//					@TopicPartition(topic = "str-topic", partitions = {"0"})
//			}
//	)
//	public void create(String message) {
//		logger.info("CREATE ::: Receive message \n{}", message);
//	}
//
//	@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory",
//			topicPartitions = {
//					@TopicPartition(topic = "str-topic", partitions = {"1"})
//			}
//	)
//	public void log(String message) {
//		logger.info("LOG ::: Receive message \n{}", message);
//	}

	@StrConsumerCustomListener(groupId = "group-0")
	public void create(String message) throws InterruptedException {
		Thread.sleep(0);
		logger.info("CREATE ::: Receive message \n{}", message);
		throw new IllegalArgumentException("Exception...");
	}

	@StrConsumerCustomListener(groupId = "group-1")
	public void log(String message) throws InterruptedException {
		Thread.sleep(1000);
		logger.info("LOG ::: Receive message \n{}", message);
	}

	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validateMessageContainerFactory")
	public void history(String message) throws InterruptedException {
		Thread.sleep(2000);
		logger.info("HISTORY ::: Receive message \n{}", message);
	}
}
