package com.book.Book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.Book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

}
