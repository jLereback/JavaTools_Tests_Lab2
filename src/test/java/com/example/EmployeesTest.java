package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

class EmployeesTest {
	EmployeeRepositoryTestDouble employeeRepository = new EmployeeRepositoryTestDouble();
	BankService bankService = Mockito.mock(BankService.class);
	Employees employees = new Employees(employeeRepository, bankService);
	Employee employee1 = new Employee("90210", 40000);
	Employee employee2 = new Employee("90502", 43000);


	@BeforeEach
	void initTests() {
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
	}

	@Test
	void doNothingResultsInPaidIsFalse() {
		assertFalse(employeeRepository.findAll().get(0).isPaid());
	}

	@Test
	void payEmployeesResultsInPaidIsTrue() {
		employees.payEmployees();

		assertTrue(employeeRepository.findAll().get(0).isPaid());
	}

	@Test
	void payEmployeesResultsInNumberOfPaymentsIsSameAmountAsNumberOfEmployees() {
		assertEquals(2, employees.payEmployees());
	}

	@Test
	void interruptedPaymentResultInPaidIsFalse() {
		doThrow(RuntimeException.class).when(bankService).pay(employee1.getId(), employee1.getSalary());
		employees.payEmployees();

		assertFalse(employee1.isPaid());
	}
}