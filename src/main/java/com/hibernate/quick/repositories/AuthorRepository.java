package com.hibernate.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.quick.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
}
