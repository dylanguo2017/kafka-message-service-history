package com.homedepot.mm.cj.kafka.message.service;

//@ActiveProfiles()
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
	
	@Mock
	Properties propertiesMock;
	
	
	@Test
	public void validInputXML() {
		when(producerMock.send(any())).thenReturn(recordMetaDataMock);
	//	doNothing().when(propertiesMock.put(any(),any()));
		//doNothing().when(propertiesMock).put(any(),any());
		kafkaMessageServiceImplMock.sendKafkaMessage("<Orders><Order></Order></Orders>");
		assertEquals(1, eccParamWraperMock.getStatus());
		assertEquals("failure", eccParamWraperMock.getStatusDesc());
	}

}
