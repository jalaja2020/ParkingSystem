package com.example.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.entity.Employee;

@Component
public class ValidationEmployeeProcessor implements ItemProcessor<Employee, Employee> {

	public Employee process(Employee employees) throws Exception {
		System.out.println("Processing Items: " + employees);
		return employees;
	}
}
