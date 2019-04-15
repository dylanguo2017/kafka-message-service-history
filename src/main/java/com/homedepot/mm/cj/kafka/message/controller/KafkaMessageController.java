package com.homedepot.mm.cj.kafka.message.controller;

import com.homedepot.mm.cj.kafka.message.service.KafkaMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageResponse;

@Controller
@RequestMapping("/kafka")
public class KafkaMessageController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageController.class);

	@Autowired
	KafkaMessageService kafkaMessageService;

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageResponse kafkaSendMessage(@RequestBody() String xml) {

		LOGGER.debug("Start kafkaSendMessage()");
		KafkaMessageResponse kafkaMessageResponse;
		if (!StringUtils.isEmpty(xml)) {
			kafkaMessageResponse = kafkaMessageService.sendKafkaMessage(xml);
		} else {
			kafkaMessageResponse = null;
			LOGGER.debug("Request XML for Kafka Service is Empty.");
		}

		LOGGER.debug("End kafkaSendMessage()");
		return kafkaMessageResponse;
	}

	@RequestMapping(value = "/sendToKafkaConnector", method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageResponse kafkaSendMessageToKafkaConnector(@RequestBody() String xml) {

		LOGGER.debug("Start kafkaSendMessage()");
		KafkaMessageResponse kafkaMessageResponse;
		if (!StringUtils.isEmpty(xml)) {
			kafkaMessageResponse = kafkaMessageService.sendToKafkaConnector(xml);
		} else {
			kafkaMessageResponse = null;
			LOGGER.debug("Request XML for Kafka Service is Empty.");
		}

		LOGGER.debug("End kafkaSendMessage()");
		return kafkaMessageResponse;
	}
	@RequestMapping(value = "/sendToKafkaConnectorJson", method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageResponse kafkaSendMessageToKafkaConnectorJson(@RequestBody() String json) {
		KafkaMessageResponse kafkaMessageResponse = new KafkaMessageResponse();

		if (!StringUtils.isEmpty(json)) {
			kafkaMessageResponse = kafkaMessageService.sendJsonToKafkaConnector(json);
		}

		return kafkaMessageResponse;
	}
	@RequestMapping("/health")
	public String health() {
		return "{\"response\" : 200}";
	}

}
