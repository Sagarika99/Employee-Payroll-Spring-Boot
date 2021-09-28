package com.bridgelabz.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeepayrollApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(EmployeepayrollApplication.class, args);
		log.info("Employee Payroll App started in {} Environment",
				context.getEnvironment().getProperty("environment"));
	}

}
