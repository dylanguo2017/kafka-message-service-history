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

	@RequestMapping(value = "/kafkaQATest",method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWraper kafkaTest(@RequestBody() String xml) {
		KafkaMessageWraper eccParamWraper = new KafkaMessageWraper();
		eccParamWraper.setStatus(0);
		eccParamWraper.setStatusDesc("success");
		Properties props = new Properties();
		props.put("bootstrap.servers",
				"url: com-kafka-qa.com.homedepot.com:9092");
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = null;

		try {
			producer = new KafkaProducer<String, String>(props);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
					"COM_ECC_XML_MESSAGE_TOPIC", "1", xml);
			Future<RecordMetadata> recordMetaData = producer
					.send(producerRecord);
			RecordMetadata recdMetaData = recordMetaData.get();
			System.out.println(recdMetaData.topic());
			System.out.println(recdMetaData.offset());
		} catch (Exception e) {
			LOGGER.error("Exception in Kafka MEssage process"+e.getMessage());
		}
		finally {
			producer.close();
		}
		return eccParamWraper;
	}
	
	@RequestMapping(value = "/kafkaDevTest",method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWraper kafkaDevTest(@RequestBody() String xml) {
		KafkaMessageWraper eccParamWraper = new KafkaMessageWraper();
		eccParamWraper.setStatus(0);
		eccParamWraper.setStatusDesc("success");
		Properties props = new Properties();
		props.put("bootstrap.servers",
				"url: com-kafka-qa.com.homedepot.com:9092");
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = null;

		try {
			producer = new KafkaProducer<String, String>(props);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
					"COM_ECC_XML_MESSAGE_TOPIC_AD", "1", xml);
			Future<RecordMetadata> recordMetaData = producer
					.send(producerRecord);
			RecordMetadata recdMetaData = recordMetaData.get();
			System.out.println(recdMetaData.topic());
			System.out.println(recdMetaData.offset());
		} catch (Exception e) {
			LOGGER.error("Exception in Kafka MEssage process"+e.getMessage());
		}
		finally {
			producer.close();
		}
		return eccParamWraper;
	}
	
	@RequestMapping(value = "/kafkaQPTest",method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWraper kafkaQPTest(@RequestBody() String xml) {
		KafkaMessageWraper eccParamWraper = new KafkaMessageWraper();
		eccParamWraper.setStatus(0);
		eccParamWraper.setStatusDesc("success");
		Properties props = new Properties();
		props.put("bootstrap.servers",
				"url: com-kafka-qp.com.homedepot.com:9092");
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = null;

		try {
			producer = new KafkaProducer<String, String>(props);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
					"COM_ECC_XML_MESSAGE_TOPIC", "1", xml);
			Future<RecordMetadata> recordMetaData = producer
					.send(producerRecord);
			RecordMetadata recdMetaData = recordMetaData.get();
			System.out.println(recdMetaData.topic());
			System.out.println(recdMetaData.offset());
		} catch (Exception e) {
			LOGGER.error("Exception in Kafka MEssage process"+e.getMessage());
		}
		finally {
			producer.close();
		}
		return eccParamWraper;
	}
	
	
	@RequestMapping(value = "/kafkaProdTest",method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWraper kafkaProdTest(@RequestBody() String xml) {
		KafkaMessageWraper eccParamWraper = new KafkaMessageWraper();
		eccParamWraper.setStatus(0);
		eccParamWraper.setStatusDesc("success to Prod");
		Properties props = new Properties();
		props.put("bootstrap.servers",
				"com-kafka-pr.com.homedepot.com:9092");
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");

		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
	

		Producer<String, String> producer = null;

		try {
			producer = new KafkaProducer<String, String>(props);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
					"COM_ECC_XML_MESSAGE_TOPIC", "1", xml);
			Future<RecordMetadata> recordMetaData = producer
					.send(producerRecord);
			RecordMetadata recdMetaData = recordMetaData.get();
			System.out.println(recdMetaData.topic());
			System.out.println(recdMetaData.offset());
		} catch (Exception e) {
			LOGGER.error("Exception in Kafka MEssage process"+e.getMessage());
		}
		finally {
			producer.close();
		}
		return eccParamWraper;
	}
	


}
