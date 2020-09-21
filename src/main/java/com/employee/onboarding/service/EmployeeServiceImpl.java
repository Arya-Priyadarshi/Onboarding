package com.employee.onboarding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.onboarding.model.Employee;
import com.employee.onboarding.repository.EmployeeRepository;


	
	@Service
	public class EmployeeServiceImpl implements EmployeeService {

	    private EmployeeRepository employeeRepository;

	    @Autowired
	    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }

	    @Override
	    public Iterable<Employee> findAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    @Override
	    public Employee getEmployeeById(Long id) {
	        return employeeRepository.findById(id).get();
	    }

	    @Override
	    public Employee saveEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    @Override
	    public void deleteEmployee(Long id) {
	         employeeRepository.deleteById(id);;
	    }
	    
	    @Override
	    public Employee taxCalculator(Employee employee) 
	    
	    {
	    	Double tax = taxCalculator(employee.getSalary());
	    	employee.setTax(tax);
	    	
	        return employee;
	    }
	    
	    private double taxCalculator(Double salary) 
	    {
	    	
	    	Double taxAmount = 0.0;
	    	
	    	
	    	if(salary < 18200) 
	    	{
	    		taxAmount=0.0;
	    		
	    	}else if(salary > 18200 && salary <=37000) 
	    	{
	    		Double taxableSalary = salary - 18200;
	    		taxAmount = taxableSalary * 0.19 ;
	    		
	    	}else if(salary > 37000 && salary <=90000) 
	    	{
                Double taxableSalary = salary - 37000;
	    		taxAmount = 3572 +(taxableSalary * 0.325 );
	    		
	    	}else if(salary > 90000 && salary <=180000)
	    	{
	    		 Double taxableSalary = salary - 90000;
		    	 taxAmount = 20797 +(taxableSalary * 0.37 );
	    		
	    	}else if(salary > 180000)
    	    {
	    		 Double taxableSalary = salary - 180000;
		    	 taxAmount = 54097 +(taxableSalary * 0.45 );
    	    }
	    	
	    	return taxAmount;
	    }
	    

}
