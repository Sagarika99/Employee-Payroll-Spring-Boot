package com.bridgelabz.employeepayroll.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<String> getEmployeePayrollData(){
		return new ResponseEntity<String>("Get call Success", HttpStatus.OK);
	}
	
	@RequestMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeePayrollData(@PathVariable ("empId") int empId){
		return new ResponseEntity<String>("Get call Success for id ", HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		return new ResponseEntity<String>("Created Employee Payroll data for: " +empPayrollDTO, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		return new ResponseEntity<String>("Updated Employee Payroll data for: " +empPayrollDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> addEmployeePayrollData(@PathVariable ("empId") int empId){
		return new ResponseEntity<String>("Delete call Success for id: " +empId, HttpStatus.OK);
	}
}
