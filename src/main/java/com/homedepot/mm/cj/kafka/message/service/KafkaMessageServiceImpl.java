package com.homedepot.mm.cj.kafka.message.service;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWrapper;

@Service
public class KafkaMessageServiceImpl  implements KafkaMessageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageServiceImpl.class);
	
	static final String SERIALIZER_KEY = "org.apache.kafka.common.serialization.StringSerializer";
	static final String SERIALIZER_VALUE = "org.apache.kafka.common.serialization.StringSerializer";
	
	private String kafkaTopicName;
	
	private String kafkaServerUrl;
	
	KafkaMessageWrapper kafkaMessageWraper;
	
	@Autowired
	public KafkaMessageServiceImpl(KafkaMessageWrapper kafkaMessageWraper, @Value("${kafka.server.topic}") String kafkaTopicName,  @Value("${kafka.server.url}") String kafkaServerUrl) {
		this.kafkaTopicName = kafkaTopicName;
		this.kafkaServerUrl = kafkaServerUrl;
		this.kafkaMessageWraper = kafkaMessageWraper;
	}
	 
	public KafkaMessageWrapper sendKafkaMessage(String requestXML) {
		
		kafkaMessageWraper = new KafkaMessageWrapper();

		kafkaMessageWraper.setStatus(0);
		kafkaMessageWraper.setStatusDesc("success");
		Properties props = new Properties();
		props.put("bootstrap.servers",kafkaServerUrl);
		props.put("key.serializer",SERIALIZER_KEY);
		props.put("value.serializer",SERIALIZER_VALUE);

		Producer<String, String> producer = null;

		try {
			producer = new KafkaProducer<String, String>(props);
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(
					kafkaTopicName, requestXML);
			Future<RecordMetadata> recordMetaData = producer
					.send(producerRecord);
			RecordMetadata recdMetaData = recordMetaData.get();
			LOGGER.debug("recdMetaData.topic() ==>"+recdMetaData.topic());
			LOGGER.debug("recdMetaData.offset() ==>"+recdMetaData.offset());
		} catch (Exception e) {
			kafkaMessageWraper.setStatus(1);
			kafkaMessageWraper.setStatusDesc("failure");
			LOGGER.error("Exception in Kafka MEssage process"+e.getMessage());
		}
		finally {
			producer.close();
		}
		return kafkaMessageWraper;
	}

	
}
