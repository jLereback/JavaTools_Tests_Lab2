package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EmployeeTest {

	Employee employee = new Employee("90210", 40000);

	@Test
	void setIdShouldSetEmployeeIdToInputValue() {
		employee.setId("90211");
		assertThat(employee.getId()).isEqualTo("90211");
	}

	@Test
	void setSalaryShouldSetEmployeeSalaryToInputValue() {
		employee.setSalary(42000);
		assertThat(employee.getSalary()).isEqualTo(42000);
	}

	@Test
	void isPaidShouldReturnFalseWhenEmployeeIsNotPaid() {
		assertFalse(employee.isPaid());
	}

	@Test
	void isPaidShouldReturnTrueWhenEmployeeIsPaid() {
		employee.setPaid(true);
		assertTrue(employee.isPaid());
	}

	@Test
	void toStringShouldReturnEmployeeAsString() {
		assertThat(employee.toString()).hasToString("Employee [id=90210, salary=40000.0]");
	}
}