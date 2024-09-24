package com.book.Book.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.Book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

	@Query("select b from Book b where b.isbn=?1")
	Optional<Book> findByIsbn(String isbn);

}
