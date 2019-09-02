package com.hibernate.quick.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.quick.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
