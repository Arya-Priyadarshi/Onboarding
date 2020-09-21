package com.employee.onboarding.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.onboarding.model.Employee;



/**
 * @author aryansh
 *
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
