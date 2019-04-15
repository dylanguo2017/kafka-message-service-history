package com.homedepot.mm.cj.kafka.message.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageResponse;
import com.homedepot.mm.cj.kafka.message.service.KafkaMessageService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class KafkaMessageControllerTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    KafkaMessageService kafkaMessageServiceMock;

    @InjectMocks
    KafkaMessageController kafkaMessageController;

    @Test
    public void invalidRequestXML() {
        KafkaMessageResponse response = kafkaMessageController.sendKafkaMessageToTCLD("");
        assertEquals(null, response);
    }

    @Test
    public void validRequestXML() {
        KafkaMessageResponse expected = KafkaMessageResponse.builder()
          .status(0)
          .statusDesc("success")
          .build();
        when(kafkaMessageServiceMock.sendMessageToTcld(anyString())).thenReturn(expected);
        KafkaMessageResponse actual = kafkaMessageController
          .sendKafkaMessageToTCLD("<Orders><Order></Order></Orders>");
        assertThat(actual, is(expected));
    }

}
