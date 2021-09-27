package com.bridgelabz.employeepayroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayroll.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
<<<<<<< HEAD
=======
import com.bridgelabz.employeepayroll.services.IEmployeePayrollService;
>>>>>>> UC2

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
<<<<<<< HEAD
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, new EmployeePayrollDTO("Pankaj",30000));
		ResponseDTO respDTO = new ResponseDTO("Get Call Success", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@RequestMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable ("empId") int empId){
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empId, new EmployeePayrollDTO("Pankaj",30000));
		ResponseDTO respDTO = new ResponseDTO("Get Call for ID Success", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
=======
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable ("empId") int empId){
		EmployeePayrollData employeePayrollData=employeePayrollService.getEmployeePayrollData(empId);
		ResponseDTO respDTO=new ResponseDTO("Get call Success",employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
>>>>>>> UC2
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
<<<<<<< HEAD
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created employee payroll data successfully", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll data for: ", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@PathVariable ("empId") int empId){
=======
		EmployeePayrollData employeePayrollData=employeePayrollService.addEmployeePayrollData(empPayrollDTO);
		ResponseDTO respDTO=new ResponseDTO("Created Employee Payroll Data Sucessfully ",employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable ("empId") int empId, @RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData employeePayrollData=employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
		ResponseDTO respDTO=new ResponseDTO("Updates Employee Payroll Data Sucessfully",employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable ("empId") int empId){
>>>>>>> UC2
		ResponseDTO respDTO=new ResponseDTO("Deleted Sucessfully","Deleted Id: "+empId);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
}
