package com.homedepot.mm.cj.kafka.message.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWraper;
import com.homedepot.mm.cj.kafka.message.service.KafkaMessageServiceImpl;

public class KafkaMessageControllerTest {
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Mock
	KafkaMessageServiceImpl kafkaMessageServiceImplMock;
	
	@Mock
	KafkaMessageWraper eccParamWraperMock;

	@InjectMocks
	KafkaMessageController kafkaMessageController;
	
	@Test
	public void invalidRequestXML() {
		KafkaMessageWraper eccParamWraper = kafkaMessageController.kafkaSendMessage("");
		assertEquals(null,eccParamWraper);
	}
	
	@Test
	public void validRequestXML() {
		when(kafkaMessageServiceImplMock.sendKafkaMessage(anyString())).thenReturn(eccParamWraperMock);
		KafkaMessageWraper eccParamWraper = kafkaMessageController.kafkaSendMessage("<Orders><Order></Order></Orders>");
		assertNotNull(eccParamWraper);
	}

}
