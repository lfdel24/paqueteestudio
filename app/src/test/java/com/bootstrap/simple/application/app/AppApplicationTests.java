package com.bootstrap.simple.application.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import com.bootstrap.simple.application.app.persistence.model.Book;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppApplicationTests {

	private static final String API_BOOKS = "http://localhost:8081/api/books";

	@Test
	void contextLoads() {

	}

	// private Book createRandom() {
	// Book book = new Book();
	// book.setTitle(RandomStringUtils.randomAlphanumeric(10));
	// book.setAuthor(RandomStringUtils.randomAlphanumeric(10));
	// return book;
	// }

	// private String createBookAsUri(Book book) {
	// Response response =
	// RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(book).post(API_ROOT);
	// return API_BOOKS + "/" + response.jsonPath().get("id");
	// }

	@Test
	public void whenGetAllBooks_thenOK() {
		Response r = RestAssured.get(API_BOOKS);
		assertEquals(HttpStatus.OK.value(), r.getStatusCode());
	}

	// @Test
	// public void whenGetBooksByTitle_thenOK() {
	// Book book = createRandom();
	// createBookAsUri(book);
	// Response r = RestAssured.get(API_BOOKS+"/title/"+book.getTitle());
	// assertEquals(HttpStatus.OK.value(), r.getStatusCode());
	// }

}
