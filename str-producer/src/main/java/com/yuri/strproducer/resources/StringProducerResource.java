package com.yuri.strproducer.resources;

import com.yuri.strproducer.services.StringProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/strproducer")
public class StringProducerResource {

	private final StringProducerService producerService;

	@Autowired
	public StringProducerResource(StringProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping
	public ResponseEntity<Void> sendMessage(@RequestBody String message){
		producerService.sendMessage(message);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
