package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeRepositoryImplTest {
	EmployeeRepositoryImpl employeeRepository;
	Employee employee1 = new Employee("90210", 40000);
	Employee employee2 = new Employee("90502", 43000);


	@BeforeEach
	void initTests() {
		employeeRepository = new EmployeeRepositoryImpl(List.of(employee1, employee2));
	}

	@Test
	void findAllReturnSameAmountAsNumberOfEmployees() {
		assertEquals(2, employeeRepository.findAll().size());
	}

	@Test
	void saveExistingEmployeeWithUpdatedSalaryDoesNotResultInIncreasedAmountOfEmployees() {
		employee1.setSalary(42000);
		employeeRepository.save(employee1);
		assertEquals(2, employeeRepository.findAll().size());
	}
}