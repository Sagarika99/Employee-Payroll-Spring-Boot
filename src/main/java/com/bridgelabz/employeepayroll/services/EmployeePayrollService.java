package com.bridgelabz.employeepayroll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.exceptions.EmployeePayrollException;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
	
	@Autowired
	private EmployeePayrollRepository empRepository;
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return empRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollData(int empId) {
		return empRepository.findById(empId)
		.orElseThrow(()->new EmployeePayrollException("Employee with employeeId "+empId+" does not exits!!"));
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=null;
		empData=new EmployeePayrollData(empPayrollDTO);
		log.debug("Emp data: "+empData.toString());		
		return empRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=this.getEmployeePayrollData(empId);
		empData.updateEmployeePayrollData(empPayrollDTO);
		return empRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData empData=this.getEmployeePayrollData(empId);
		empRepository.delete(empData);	
	}

	
}
