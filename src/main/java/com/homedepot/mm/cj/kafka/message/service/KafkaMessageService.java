package com.homedepot.mm.cj.kafka.message.service;

import org.springframework.stereotype.Component;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWrapper;

@Component
public interface KafkaMessageService {
	
	public KafkaMessageWrapper sendKafkaMessage(String orderXML);
	
}
