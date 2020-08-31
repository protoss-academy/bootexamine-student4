package com.protosstechnology.train.bootexamine;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BootexamineApplicationTests {

	@Test
	void contextLoads() {
		log.info("contextLoads");
		assertTrue(true);
	}

}
