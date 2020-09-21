package com.employee.onboarding.service;

import com.employee.onboarding.model.Employee;

/**
 * @author aryansh
 *
 */
public interface EmployeeService {

	Iterable<Employee> findAllEmployees();

	Employee getEmployeeById(Long id);

	Employee saveEmployee(Employee employee);

	void deleteEmployee(Long id);
	
	
	Employee taxCalculator(Employee employee);
}
