package com.homedepot.mm.cj.kafka.message.service;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageResponse;
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

@Service
public class KafkaMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageService.class);

    static final String SERIALIZER_KEY = "org.apache.kafka.common.serialization.StringSerializer";
    static final String SERIALIZER_VALUE = "org.apache.kafka.common.serialization.StringSerializer";

    private String kafkaServerUrl;

    private KafkaMessageResponse kafkaMessageResponse;

    private String kafkaTCLDTopicName;

    private String kafkaGCP_XMLTopicName;

    private String kafkaGCP_JSONTopicName;


    @Autowired
    public KafkaMessageService(@Value("${kafka.server.url}") String kafkaServerUrl,
      @Value("${kafka.server.topic}") String kafkaTCLDTopicName,
      @Value("${kafka.server.connector}") String kafkaGCP_XMLTopicName,
      @Value("${kafka.server.json}") String kafkaGCP_JSONTopicName) {

        this.kafkaServerUrl = kafkaServerUrl;
        this.kafkaMessageResponse = KafkaMessageResponse.builder().build();
        this.kafkaTCLDTopicName = kafkaTCLDTopicName;
        this.kafkaGCP_XMLTopicName = kafkaGCP_XMLTopicName;
        this.kafkaGCP_JSONTopicName = kafkaGCP_JSONTopicName;
    }


    public KafkaMessageResponse sendMessageToTcld(String xmlPayload) {
        sendMessageToTopic(xmlPayload, kafkaTCLDTopicName);
        return kafkaMessageResponse;
    }

    public KafkaMessageResponse sendXmlMessageToKafkaConnector(String xmlPayload) {
        sendMessageToTopic(xmlPayload, kafkaGCP_XMLTopicName);
        return kafkaMessageResponse;
    }

    public KafkaMessageResponse sendJsonMessageToJsonTransformer(String jsonPayload) {
        sendMessageToTopic(jsonPayload, kafkaGCP_JSONTopicName);
        return kafkaMessageResponse;
    }

    public void sendMessageToTopic(String payload, String topicName) {

        Properties props = setUpCommonProperties();

        Producer<String, String> producer = null;

        try {

            producer = new KafkaProducer<>(props);
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topicName,
              payload);

            Future<RecordMetadata> recordMetaData = producer
              .send(producerRecord);

            RecordMetadata recdMetaData = recordMetaData.get();
            kafkaMessageResponse.setStatus(0);
            kafkaMessageResponse.setStatusDesc("success");
            LOGGER.debug("recdMetaData.topic() ==>" + recdMetaData.topic());
            LOGGER.debug("recdMetaData.offset() ==>" + recdMetaData.offset());
        } catch (Exception e) {
            LOGGER.error("Exception in Kafka MEssage process" + e.getMessage());
        } finally {
            producer.close();
        }
    }

    private Properties setUpCommonProperties() {
        Properties props = new Properties();
        kafkaMessageResponse.setStatus(1);
        kafkaMessageResponse.setStatusDesc("failure");
        props.put("bootstrap.servers", kafkaServerUrl);
        props.put("key.serializer", SERIALIZER_KEY);
        props.put("value.serializer", SERIALIZER_VALUE);

        return props;
    }

}
