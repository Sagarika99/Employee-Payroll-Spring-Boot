package com.bridgelabz.employeepayroll.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
		employeePayrollList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",3000)));		
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollData(int empId) {
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",3000));
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(3,empPayrollDTO);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData employeePayrollData=null;
		employeePayrollData=new EmployeePayrollData(empId,empPayrollDTO);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		// TODO Auto-generated method stub
		
	}

	
}
