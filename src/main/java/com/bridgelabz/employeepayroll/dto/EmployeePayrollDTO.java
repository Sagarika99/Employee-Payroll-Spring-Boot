package com.bridgelabz.employeepayroll.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {

	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Employee name invalid")
	public String name;
	@Min(value=500, message="Min Wage should be more than 500")
	public long salary;	
	
	public EmployeePayrollDTO() {}
	
	public EmployeePayrollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}
	
	
	
}
