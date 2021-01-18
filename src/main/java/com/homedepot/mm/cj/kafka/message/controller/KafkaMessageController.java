package com.homedepot.mm.cj.kafka.message.controller;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageResponse;
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

@Controller
@RequestMapping("/kafka")
public class KafkaMessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageController.class);

    @Autowired
    KafkaMessageService kafkaMessageService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    public KafkaMessageResponse sendKafkaMessageToTCLD(@RequestBody() String xml) {

        LOGGER.debug("Start sendKafkaMessageToTCLD()");
        KafkaMessageResponse kafkaMessageResponse;
        if (!StringUtils.isEmpty(xml)) {
            kafkaMessageResponse = kafkaMessageService.sendMessageToTcld(xml);
        } else {
            kafkaMessageResponse = null;
            LOGGER.debug("Request XML for Kafka Service is Empty.");
        }

        LOGGER.debug("End sendKafkaMessageToTCLD()");
        return kafkaMessageResponse;
    }

    @RequestMapping(value = "/sendToKafkaConnector", method = RequestMethod.POST)
    @ResponseBody
    public KafkaMessageResponse sendKafkaMessageToGCPXMLflow(@RequestBody() String xml) {

        LOGGER.debug("Start sendKafkaMessageToGCPXMLflow()");
        KafkaMessageResponse kafkaMessageResponse;
        if (!StringUtils.isEmpty(xml)) {
            kafkaMessageResponse = kafkaMessageService.sendXmlMessageToKafkaConnector(xml);
        } else {
            kafkaMessageResponse = null;
            LOGGER.debug("Request XML for Kafka Service is Empty.");
        }

        LOGGER.debug("End sendKafkaMessageToGCPXMLflow()");
        return kafkaMessageResponse;
    }

    @RequestMapping(value = "/sendJsonToKafkaConnector", method = RequestMethod.POST)
    @ResponseBody
    public KafkaMessageResponse sendKafkaMessageToGCPJSONflow(@RequestBody() String json) {

        KafkaMessageResponse kafkaMessageResponse;

        LOGGER.debug("Start sendKafkaMessageToGCPJSONflow()");

        if (!StringUtils.isEmpty(json)) {
            kafkaMessageResponse = kafkaMessageService.sendJsonMessageToJsonTransformer(json);
        } else {
            kafkaMessageResponse = null;
            LOGGER.debug("Request JSON for Kafka Service is Empty.");
        }

        LOGGER.debug("End sendKafkaMessageToGCPJSONflow()");

        return kafkaMessageResponse;
    }

    @RequestMapping("/health")
    public String health() {
        return "{\"response\" : 200}";
    }

}
