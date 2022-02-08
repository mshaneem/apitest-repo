package com.shaneem.cbatestms;

import static org.junit.jupiter.api.Assertions.*;

import java.net.http.HttpHeaders;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.shaneem.cbatestms.repo.bookrepo;




/**
 * @author mohammedshaneem
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CbatestmsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BooksResourceTest {
	@LocalServerPort
	private int port;

	private bookrepo repo;
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers;

	@Test
	void test_getBooks() throws Exception {
		HttpEntity<String> entity = null;
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/books"),
				HttpMethod.GET, entity, String.class);
		
		assertTrue(response.hasBody());
		System.out.print(response.getBody());
	}
		
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
