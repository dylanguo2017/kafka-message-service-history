package com.homedepot.mm.cj.kafka.message.controller;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWraper;

@Controller
@RequestMapping("/kafkamessage")
public class KafkaMessageController {
	private static final Logger LOGGER = Logger.getLogger(KafkaMessageController.class);

//	@Autowired
//	EccParamService eccParamService;
//	List<EccParamResponse> eccParamResponseList;
	


	@RequestMapping(value = "/kafkaTest",method = RequestMethod.POST)
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
		finally {
			producer.close();
		}
		return eccParamWraper;
	}
	
	@RequestMapping(value = "/kafkaQHTest",method = RequestMethod.POST)
	@ResponseBody
	public KafkaMessageWraper pushToQuietHoursKafka(@RequestBody() String xml) {
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
					"ECC_OPT_IN_OPT_OUT_QUIET_HRS_QA", "1", xml);
			Future<RecordMetadata> recordMetaData = producer
					.send(producerRecord);
			RecordMetadata recdMetaData = recordMetaData.get();
			System.out.println(recdMetaData.topic());
			System.out.println(recdMetaData.offset());
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
		finally {
			producer.close();
		}
		return eccParamWraper;
	}
	
//	@RequestMapping(value = "/EccPcfParam", method = RequestMethod.GET)
//	public String getEccPcfParamPage(Model model) {
//		LOGGER.info("Inside getEccPcfParamPage() method");
//		eccParamResponseList = new ArrayList<>();
//		EccParamWraper eccParamWraper = new EccParamWraper();
//		eccParamWraper = eccParamService.getFlagDetail();
//		eccParamResponseList = eccParamWraper.getEccParamResponse();
//		model.addAttribute("eccParamWraper", eccParamWraper);
//		return "index";
//	}
//
//	@RequestMapping(value = "/setEccPcfParam", method = RequestMethod.POST)
//	public String setEccPcfParam(@ModelAttribute("eccParamWraper") EccParamWraper eccParamWraper, Model model) {
//		LOGGER.info("Inside setEccPcfParam() method");
//		eccParamService.updateFlagDetail(eccParamWraper);
//		return "index";
//	}
//
//	@RequestMapping("/getEccPcfParam")
//	@ResponseBody
//	public EccParamWraper getEccPcfParam(@RequestParam(value = "srccd", required = false) String src_cd) {
//		LOGGER.info("*******Inside getEccPcfParam() method :: BEGIN src_cd is "+src_cd);
//		EccParamWraper eccParamWraper = new EccParamWraper();
//		if (src_cd != null && !src_cd.isEmpty()) {
//			eccParamWraper = eccParamService.getFlagDetailBySrcCd(src_cd);
//		}
//		if(null!=eccParamWraper.getEccParamResponse() && !eccParamWraper.getEccParamResponse().isEmpty()){
//			eccParamWraper.setStatus(0);
//			eccParamWraper.setStatusDesc("success");
//		}else{			
//			eccParamWraper.setStatus(1);
//			eccParamWraper.setStatusDesc("Invalid Client Id");
//		}
//		LOGGER.info("*******Inside getEccPcfParam() method :: END " +eccParamWraper.toString());
//		return eccParamWraper;
//	}

}
