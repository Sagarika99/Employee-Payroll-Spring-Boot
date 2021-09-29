package com.bridgelabz.employeepayroll.model;

import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;

import lombok.Data;

public @Data class EmployeePayrollData {

	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;
	
	public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
		this.employeeId = employeeId;
		this.updateEmployeePayrollData(employeePayrollDTO);
	}
	
	public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
		this.gender = employeePayrollDTO.gender;
		this.note = employeePayrollDTO.note;
		this.startDate = employeePayrollDTO.startDate;
		this.profilePic = employeePayrollDTO.profilePic;
		this.departments = employeePayrollDTO.departments;
	}
	
}
