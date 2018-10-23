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

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageWrapper;
import com.homedepot.mm.cj.kafka.message.service.KafkaMessageServiceImpl;

public class KafkaMessageControllerTest {
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Mock
	KafkaMessageServiceImpl kafkaMessageServiceImplMock;
	
	@Mock
	KafkaMessageWrapper eccParamWraperMock;

	@InjectMocks
	KafkaMessageController kafkaMessageController;
	
	@Test
	public void invalidRequestXML() {
		KafkaMessageWrapper eccParamWraper = kafkaMessageController.kafkaSendMessage("");
		assertEquals(null,eccParamWraper);
	}
	
	@Test
	public void validRequestXML() {
		when(kafkaMessageServiceImplMock.sendKafkaMessage(anyString())).thenReturn(eccParamWraperMock);
		KafkaMessageWrapper eccParamWraper = kafkaMessageController.kafkaSendMessage("<Orders><Order></Order></Orders>");
		assertNotNull(eccParamWraper);
	}

}
