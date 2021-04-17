package com.java.springboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.springboot.example.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
