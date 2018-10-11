package com.homedepot.mm.cj.kafka.message.controller;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/kafkamessage")
public class KafkaMessageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageController.class);

	@RequestMapping(value = "/kafkaDevTest",method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWraper kafkaDevTest(@RequestBody() String xml) {
		KafkaMessageWraper eccParamWraper = new KafkaMessageWraper();
		eccParamWraper.setStatus(0);
		eccParamWraper.setStatusDesc("success");
		Properties props = getProperties("url: com-kafka-qa.com.homedepot.com:9092");

		Producer<String, String> producer = null;

		produceMessage(xml, props, producer);
		return eccParamWraper;
	}

	@RequestMapping(value = "/kafkaQPTest",method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWraper kafkaQPTest(@RequestBody() String xml) {
		KafkaMessageWraper eccParamWraper = new KafkaMessageWraper();
		eccParamWraper.setStatus(0);
		eccParamWraper.setStatusDesc("success");
		Properties props = getProperties("url: com-kafka-qp.com.homedepot.com:9092");

		Producer<String, String> producer = null;

		produceMessage(xml, props, producer);
		return eccParamWraper;
	}


	@RequestMapping(value = "/kafkaProdTest",method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWraper kafkaProdTest(@RequestBody() String xml) {
		KafkaMessageWraper eccParamWraper = new KafkaMessageWraper();
		eccParamWraper.setStatus(0);
		eccParamWraper.setStatusDesc("success to Prod");
		Properties props = getProperties("com-kafka-pr.com.homedepot.com:9092");


		Producer<String, String> producer = null;

		produceMessage(xml, props, producer);
		return eccParamWraper;
	}
	// Keeping this here in case you want to uncomment and use this mapping to test locally :)
//	@RequestMapping(value = "/kafkaLocalTest",method = RequestMethod.POST)
//	@ResponseBody
//	public KafkaMessageWraper kafkaTest(@RequestBody() String xml) {
//		KafkaMessageWraper eccParamWraper = new KafkaMessageWraper();
//		eccParamWraper.setStatus(0);
//		eccParamWraper.setStatusDesc("success");
//		Properties props = getProperties("url: com-kafka-qa.com.homedepot.com:9092");
//
//		Producer<String, String> producer = null;
//
//		produceMessage(xml, props, producer);
//
//		return eccParamWraper;
//	}


	private Properties getProperties(String bootstrap) {
		Properties props = new Properties();
		props.put("bootstrap.servers",bootstrap);
		props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		return props;
	}

	private void produceMessage(@RequestBody String xml, Properties props, Producer<String, String> producer) {
		LOGGER.info("Incoming message : "+ xml);
		try {
			producer = new KafkaProducer<String, String>(props);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
					"COM_ECC_XML_MESSAGE_TOPIC", xml);

			Future<RecordMetadata> recordMetaData = producer
					.send(producerRecord);
			RecordMetadata recdMetaData = recordMetaData.get();

			LOGGER.info(recdMetaData.topic());
			LOGGER.info(Long.toString(recdMetaData.offset()));
			LOGGER.info("Partition # : "+recdMetaData.partition());
		} catch (Exception e) {
			LOGGER.error("Exception in Kafka MEssage process"+e.getMessage());
		}
		finally {
			producer.close();
		}
	}



}
