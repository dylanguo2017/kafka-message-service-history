package com.homedepot.mm.cj.kafka.message.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.concurrent.Future;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWraper;

public class KafkaMessageServiceImplTest {

	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@InjectMocks
	KafkaMessageServiceImpl kafkaMessageServiceImplMock;
	
	@Mock
	KafkaMessageWraper eccParamWraperMock;
	
	@Mock
	Producer<String, String> producerMock; 
	
	@Mock
	Future<RecordMetadata> recordMetaDataMock;
	
	@Test
	public void validInputXML() {
		String fileName = "./src/test/java/com/homedepot/mm/cj/kafka/message/service/xml/THDReadyForPickUpOrders.xml";
        String message = convertXMLFileToString(fileName);
       
		when(producerMock.send(any())).thenReturn(recordMetaDataMock);
		kafkaMessageServiceImplMock = new KafkaMessageServiceImpl(eccParamWraperMock, "COM_ECC_XML_MESSAGE_TOPIC_AD","com-kafka-qa.com.homedepot.com:9092");
		eccParamWraperMock = kafkaMessageServiceImplMock.sendKafkaMessage(message);
		assertEquals(0, eccParamWraperMock.getStatus());
		assertEquals("success", eccParamWraperMock.getStatusDesc());
	}
	
	 public static String convertXMLFileToString(String fileName) {
	        try {
	            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	            InputStream inputStream = new FileInputStream(new File(fileName));
	            org.w3c.dom.Document doc = documentBuilderFactory.newDocumentBuilder()
	              .parse(inputStream);
	            StringWriter stw = new StringWriter();
	            Transformer serializer = TransformerFactory.newInstance().newTransformer();
	            serializer.transform(new DOMSource(doc), new StreamResult(stw));
	            return stw.toString();
	        } catch (Exception e) {
	            String error = "convertXMLFileToString failed";
	        }
	        return null;
	    }


}
