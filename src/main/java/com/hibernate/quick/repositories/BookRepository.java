package com.hibernate.quick.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.quick.entities.Author;
import com.hibernate.quick.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findAllByAuthor(Author author);
}
