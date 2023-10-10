package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.entity.Employee;

import java.util.List;


public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
}
