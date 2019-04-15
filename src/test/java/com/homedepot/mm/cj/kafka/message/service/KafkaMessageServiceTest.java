package com.homedepot.mm.cj.kafka.message.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.homedepot.mm.cj.kafka.message.dto.KafkaMessageResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class KafkaMessageServiceTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    KafkaMessageService kafkaMessageServiceMock;

    @Test
    public void validInputXML() {
        String fileName = "./src/test/java/com/homedepot/mm/cj/kafka/message/service/xml/THDReadyForPickUpOrders.xml";
        String message = convertXMLFileToString(fileName);
        KafkaMessageResponse expectedResponse = KafkaMessageResponse.builder().statusDesc("success")
          .status(0).build();
        when(kafkaMessageServiceMock.sendMessageToTcld(any())).thenReturn(KafkaMessageResponse.builder().statusDesc("success")
          .status(0).build());
        KafkaMessageResponse actualResponse = kafkaMessageServiceMock.sendMessageToTcld(message);
        assertThat(actualResponse, is(expectedResponse));

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
