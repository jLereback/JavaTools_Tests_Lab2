package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class EmployeesTest {
	EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
	BankService bankService = Mockito.mock(BankService.class);


	@Test
	void payEmployees() {

	}
}