package com.java.springboot.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.example.model.Employee;
import com.java.springboot.example.repository.EmployeeRepository;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;
	
	/* to save an employee */
	public Employee save(Employee emp){
		return employeeRepository.save(emp);
	}

	/* search all employee */
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}

	/* get all employee by Id*/
	public Employee findOne(Long empId){
		return employeeRepository.findOne(empId);
	}

	/* delete an employee */
	public void delete(Employee emp){
		employeeRepository.delete(emp);
	}
}
