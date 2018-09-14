package com.homedepot.mm.cj.kafka.message.service;

import org.springframework.stereotype.Component;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWraper;

@Component
public interface KafkaMessageService {
	
	public KafkaMessageWraper sendKafkaMessage(String orderXML);
	
}
