package hu.springbootrestfuljpa.books.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import hu.springbootrestfuljpa.books.model.Book;
import hu.springbootrestfuljpa.books.repository.BookRepository;

public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	BookController bookController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		/** el mock puede ir en el init o en el test */

	}

	@Test
	public void retrieveAllBooksTest() {
		final Book books = new Book();
		Mockito.when(bookRepository.findAll()).thenReturn(Arrays.asList(books));
		final List<Book> response = bookController.retrieveAllBooks();
		assertNotNull(response);
		assertFalse(response.isEmpty());
		assertEquals(response.size(), 1);
	}

	@Test
	public void retrieveBookTest() {
		Optional<Book> returnOptional = Optional.of(new Book(1, "book1", 1, "autor", new ArrayList<>()));
		Mockito.when(bookRepository.findById(1)).thenReturn(returnOptional);
		assertEquals(bookRepository.findById(1).get(), bookController.retrieveBook(1).getBody());

	}

//	@Test
//	public void retrieveBookTest2() throws Exception {
//		Optional<Book> returnOptional = Optional.of(new Book(1, "book1", 1, "autor", new ArrayList<>()));
//
//		Mockito.when(bookRepository.findById(Mockito.anyInt())).thenReturn(returnOptional);
//
////		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/books/100").accept(
////				MediaType.APPLICATION_JSON);
//
//		this.mockMvc.perform(get("/books/1")).andExpect(status().isOk())
//				.andExpect(jsonPath("$.autor", is(returnOptional.get().getAuthor())));
//
////		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////		System.out.println(result.getResponse());
////		String expected = "{id:100,author:1stauth,release:2010,title:1sttitle,reviews:[{id:110,description:1st comment},{id:111,description:2st comment},{id:112,description:3st comment}]}";
////		
////		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);	
//
//	}
	
	String exampleRequest = "{\"id\":3,\"author\":\"1stauth\",\"release\":2010,\"title\":\"1sttitle\",\"reviews\":[]}";
	
	public void createBookTest() throws Exception {
		
		Book book = new Book(1, "autor", 2010, "titulo", new ArrayList<>());
		Mockito.when(bookRepository.existsById(1)).thenReturn(true);
//		Mockito.when()
		
	}
	
	
}
