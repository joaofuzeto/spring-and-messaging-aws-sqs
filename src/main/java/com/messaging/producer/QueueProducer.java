package com.messaging.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;

@RestController
public class QueueProducer {
	
	@Value("${cloud.aws.sqs.endpoint}")
	private String uri;
	
	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;
	
	@PostMapping("/send")
	public void send(@RequestBody String message) {
		Message payload = MessageBuilder.withPayload(message)
				.setHeader("sender", "test")
				.build();
		queueMessagingTemplate.send(uri, payload);
	}

}
