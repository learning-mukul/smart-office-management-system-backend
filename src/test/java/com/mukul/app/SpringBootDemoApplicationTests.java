package com.mukul.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "welcome-topic" })
class SpringBootDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
