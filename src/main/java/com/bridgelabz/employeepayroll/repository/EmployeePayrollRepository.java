package com.bridgelabz.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.employeepayroll.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer>{

}
