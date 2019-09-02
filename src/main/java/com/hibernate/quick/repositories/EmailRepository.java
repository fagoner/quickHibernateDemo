package com.hibernate.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.quick.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}
