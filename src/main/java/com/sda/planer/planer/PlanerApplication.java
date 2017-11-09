package com.sda.planer.planer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlanerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanerApplication.class, args);
	}
}


//Employee:
//id, firstName, lastName, phoneNumber, email, department(enum - BACKEND, FRONTEND, HR)

//Employee Controller (htmle):
//allEmployees(lista pracownikow oraz formularz), employee

//EmployeeService:
//getAll, get(id), add(employee)

//EmployeeRepository:
//

//Room
//id, name, capacity