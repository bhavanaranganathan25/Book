package com.book.Book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.book.Book.exception.InvalidIdException;
import com.book.Book.exception.InvalidIsbnException;
import com.book.Book.model.Book;
import com.book.Book.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> allBook() {
		return bookRepository.findAll();
	}

	public Book getBookByIsbn(String isbn) throws InvalidIsbnException {
		Optional<Book> optional=bookRepository.findByIsbn(isbn);
		if(optional.isEmpty()) {
			throw new InvalidIsbnException("Give the correct isbn");
		}
		Book book=optional.get();
		return book;
		
	}
	
	public Book updateBook(int bid, Book book) throws InvalidIdException {
		Optional<Book> optional=bookRepository.findById(bid);
		if(optional.isEmpty()) {
			throw new InvalidIdException("Id not found");
		}
		Book books=optional.get();
		books.setPublishedYear(book.getPublishedYear());
		return bookRepository.save(books);
		
	}
}
