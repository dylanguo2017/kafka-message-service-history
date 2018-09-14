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

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWraper;
import com.homedepot.mm.cj.kafka.message.service.KafkaMessageService;

@Controller
@RequestMapping("/kafka")
public class KafkaMessageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageController.class);

	@Autowired
	KafkaMessageService kafkaMessageService;

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWraper kafkaSendMessage(@RequestBody() String xml) {

		LOGGER.debug("Start kafkaSendMessage()");
		KafkaMessageWraper eccParamWraper = new KafkaMessageWraper();
		if (!StringUtils.isEmpty(xml)) {
			eccParamWraper = kafkaMessageService.sendKafkaMessage(xml);
		} else {
			eccParamWraper = null;
			LOGGER.debug("Request XML for Kafka Service is Empty.");
		}

		LOGGER.debug("End kafkaSendMessage()");
		return eccParamWraper;
	}

	@RequestMapping("/health")
	public String health() {
		return "{\"response\" : 200}";
	}

}
