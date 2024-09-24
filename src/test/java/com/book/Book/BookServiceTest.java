package com.book.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.Book.model.Book;
import com.book.Book.repository.BookRepository;
import com.book.Book.service.BookService;

@SpringBootTest
public class BookServiceTest {
	
	@InjectMocks
	private BookService bookService;
	
	@Mock
	private BookRepository bookRepository;
	
	@Test
	public void getallBookTest() {
		Book b1=new Book();
		b1.setId(1);
		b1.setTitle("fire wings");
		b1.setAuthor("abdul kalam");
		b1.setPublishedYear("1995");
		
		Book b2=new Book();
		b2.setId(2);
		b2.setTitle("book of joy");
		b2.setAuthor("singh");
		b2.setPublishedYear("1998");
	
	
	List<Book> list=Arrays.asList(b1,b2);
    when(bookRepository.findAll()).thenReturn(list);
    int expectedValue=2;
    List<Book> bookList=bookService.allBook();
    
    assertNotNull(bookList);
    int actualValue=bookList.size();
    assertEquals(expectedValue,actualValue);

	} 
	
	

}
