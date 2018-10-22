package com.homedepot.mm.cj.kafka.message.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWrapper;
import com.homedepot.mm.cj.kafka.message.service.KafkaMessageService;

@Controller
@RequestMapping("/kafka")
public class KafkaMessageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageController.class);

	@Autowired
	KafkaMessageService kafkaMessageService;

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWrapper kafkaSendMessage(@RequestBody() String xml) {

		LOGGER.debug("Start kafkaSendMessage()");
		KafkaMessageWrapper kafkaMessageWrapper = new KafkaMessageWrapper();
		if (!StringUtils.isEmpty(xml)) {
			kafkaMessageWrapper = kafkaMessageService.sendKafkaMessage(xml);
		} else {
			kafkaMessageWrapper = null;
			LOGGER.debug("Request XML for Kafka Service is Empty.");
		}

		LOGGER.debug("End kafkaSendMessage()");
		return kafkaMessageWrapper;
	}

	@RequestMapping("/health")
	public String health() {
		return "{\"response\" : 200}";
	}

}
