package com.bridgelabz.employeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD

import lombok.extern.slf4j.Slf4j;
=======
>>>>>>> UC1.1

@SpringBootApplication
@Slf4j
public class EmployeepayrollApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(EmployeepayrollApplication.class, args);
<<<<<<< HEAD
		log.info("Employee Payroll App started in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll DB User is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
=======
		log.info("Employee Payroll App started in {} Envoronment",
				context.getEnvironment().getProperty("environment"));
>>>>>>> UC1.1
	}

}
