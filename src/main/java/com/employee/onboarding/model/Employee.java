package com.employee.onboarding.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**
 * @author aryansh
 *
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version private Integer version;
    @NotNull
    @Size(min = 2, max = 13)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 13)
    private String lastName;
    @NotNull
    @DecimalMax("90000000")
    private Double salary;
    
    private Double tax;

    public Employee(){}

    public Employee(String firstName, String lastName, Double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	@Override
    public String toString() {
        return String.format(
                "Employee[id=%d, firstName='%s', lastName='%s', Salary='%f',tax='%f']",
                id, firstName, lastName, salary , tax);
    }

}

