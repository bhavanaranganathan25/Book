package com.book.Book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.Book.exception.InvalidIdException;
import com.book.Book.exception.InvalidIsbnException;
import com.book.Book.model.Book;
import com.book.Book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	// Add a new Book
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	// Retrieve all book
	@GetMapping("/allBook")
	public List<Book> allBook(){
		return bookService.allBook();
	}
	
	@GetMapping("/getByIsbn/{isbn}")
	public ResponseEntity<?> getByIsbn(@PathVariable String isbn){
		try {
			Book book= bookService.getBookByIsbn(isbn);
			return ResponseEntity.ok(book);
		} catch (InvalidIsbnException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		}
	
	@PutMapping("/update/{bid}")
	public void updateBook(@PathVariable int bid,@RequestBody Book book){
		try {
		      bookService.updateBook(bid,book);
			
		} catch (InvalidIdException e) {
			 e.getMessage();
		}
		
	}
	
	

}
