package com.bridgelabz.employeepayroll.services;

import java.util.ArrayList;

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
	
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
//		List<EmployeePayrollData> employeePayrollList=new ArrayList<>();
//		employeePayrollList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",3000)));		
		return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollData(int empId) {
		return employeePayrollList.stream().filter(contactData->contactData.getEmployeeId()==empId)
		.findFirst()
		.orElseThrow(()->new EmployeePayrollException("contact not found"));
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=null;
		empData=new EmployeePayrollData(empPayrollDTO);
		employeePayrollList.add(empData);
		log.debug("Emp data: "+empData.toString());		
		return empRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData=this.getEmployeePayrollData(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		employeePayrollList.set(empId-1, empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.remove(empId-1);	
	}

	
}
