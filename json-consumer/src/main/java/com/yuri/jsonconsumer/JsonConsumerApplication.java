package com.yuri.jsonconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class JsonConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonConsumerApplication.class, args);
	}

}
