/**
 * 
 */
package com.protosstechnology.train.bootexamine.controller;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.protosstechnology.train.bootexamine.entity.Document;

import lombok.extern.slf4j.Slf4j;

/**
 * <description>
 *
 * @type com.protosstechnology.train.bootexamine.controller
 * @author nattawat.k
 * @contact nattawat.k@kbtg.tech
 * @date Aug 31, 2020 2:46:28 PM
 *
 */
@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Transactional
@TestMethodOrder(OrderAnnotation.class)
class DocumentControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	void addDocument_thenOk() throws Exception {
		log.info("addDocument_thenOk()");

		Document document = new Document();
		document.setDocumentNumber("CA-1234");
		document.setDescription("Current Account");

		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(document);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/document")
				.contentType(MediaType.APPLICATION_JSON).content(json);

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@Order(2)
	void getDocument_thenOk() throws Exception {
		log.info("getDocument_thenOk()");

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/document/{id}", "1");

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@Order(3)
	void updateDocument_thenOk() throws Exception {
		log.info("updateDocument_thenOk()");

		Document document = new Document();
		document.setDocumentNumber("SA-1234");
		document.setDescription("Saving Account");

		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(document);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/document/{id}", "1")
				.contentType(MediaType.APPLICATION_JSON).content(json);

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@Order(4)
	void deleteDocument_thenOk() throws Exception {
		log.info("deleteDocument_thenOk()");

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("/document/{id}", "1");

		mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
