package com.bootstrap.simple.application.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppApplicationTests {

	private static final String HTTP_LOCALHOST_8081_API_BOOKS = "http://localhost:8081/api/books";

	@Test
	void contextLoads() {

	}

	@Test
	public void whenGetAllBooks_thenOK() {
		Response r = RestAssured.get(HTTP_LOCALHOST_8081_API_BOOKS);
		assertEquals(HttpStatus.OK.value(), r.getStatusCode());
	}

}
