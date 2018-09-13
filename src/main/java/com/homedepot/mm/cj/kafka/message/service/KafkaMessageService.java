package com.homedepot.mm.cj.kafka.message.service;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWraper;

public interface KafkaMessageService {
	
	public KafkaMessageWraper sendKafkaMessage(String orderXML);
	
}
