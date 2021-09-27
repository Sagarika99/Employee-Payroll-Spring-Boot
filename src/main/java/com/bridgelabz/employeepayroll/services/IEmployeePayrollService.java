package com.bridgelabz.employeepayroll.services;

import java.util.List;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollData(int empId);
	
	EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
	
	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);
	
	void deleteEmployeePayrollData(int empId);

}
