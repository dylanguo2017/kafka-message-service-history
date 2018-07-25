package com.homedepot.mm.cj.kafka.message;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaMessageServiceApplicationTests {

	
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void test() throws SQLException {
		System.out.println("***** TEST MESSAGE *******");

	}

}
