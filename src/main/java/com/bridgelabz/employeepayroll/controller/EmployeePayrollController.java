package com.bridgelabz.employeepayroll.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.bridgelabz.employeepayroll.services.IEmployeePayrollService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
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
	}
	
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable ("department") String department){
		List<EmployeePayrollData> employeePayrollData=employeePayrollService.getEmployeesByDepartment(department);
		ResponseDTO respDTO=new ResponseDTO("Get call Success",employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
		
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
		log.debug("Employee DTO: "+empPayrollDTO.toString());
		EmployeePayrollData employeePayrollData=employeePayrollService.addEmployeePayrollData(empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created employee payroll data successfully", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		}
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable ("empId") int empId, @RequestBody EmployeePayrollDTO empPayrollDTO){
		EmployeePayrollData employeePayrollData=employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
		ResponseDTO respDTO=new ResponseDTO("Updates Employee Payroll Data Sucessfully",employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable ("empId") int empId){
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO respDTO=new ResponseDTO("Deleted Sucessfully","Deleted Id: "+empId);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
}
