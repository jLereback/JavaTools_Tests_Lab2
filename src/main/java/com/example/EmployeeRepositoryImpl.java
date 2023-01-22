package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	List<Employee> employees = new ArrayList<>();

	public EmployeeRepositoryImpl(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public List<Employee> findAll() {
		return employees;
	}

	@Override
	public Employee save(Employee e) {
		employees.removeIf(employee -> Objects.equals(employee.getId(), e.getId()));
		employees.add(e);
		return e;
	}

}
