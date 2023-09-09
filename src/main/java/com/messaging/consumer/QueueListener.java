package com.messaging.consumer;

import org.springframework.stereotype.Service;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;

@Service
public class QueueListener {
	
	@SqsListener(value = "my-first-queue")
	public void listen(String message) {
		System.out.println(message);
	}
	
}
