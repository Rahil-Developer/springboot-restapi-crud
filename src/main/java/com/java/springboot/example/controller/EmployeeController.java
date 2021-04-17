package com.java.springboot.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.example.dao.EmployeeDao;
import com.java.springboot.example.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;

	/* to save an employee*/
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp){
		return employeeDao.save(emp);
	}

	/* create get all emnployee*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDao.findAll();
	} 

	/* get employee by empId */
	@GetMapping("/notes/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value ="id") Long empId){
		Employee emp = employeeDao.findOne(empId);
		if(emp == null){
			return ResponseEntity.notFound().build();
		}else{
			return ResponseEntity.ok().body(emp);				
		}
	}

	/* update an employee by empId */
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmplpoyee(@PathVariable(value ="id") Long empId, @Valid @RequestBody Employee empDetails){
		Employee emp = employeeDao.findOne(empId);
		if(emp == null){
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());

		Employee updateEmplpoyee = employeeDao.save(emp);
		return ResponseEntity.ok().body(updateEmplpoyee); 	 
	}

	/* Delete an Employee */
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empId){

		 Employee emp = employeeDao.findOne(empId);
		 if(emp == null){
		 	return ResponseEntity.notFound().build();
		 }
		 employeeDao.delete(emp);

		 return ResponseEntity.ok().build();
	}
}
