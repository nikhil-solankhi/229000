package com.app.service;

import java.util.List;

import com.app.dto.LoginRequestDto;
import com.app.pojos.Employee;

public interface EmployeeService {
	List<Employee> getAllEmpDetails();

	Employee addEmpDetails(Employee transientEmp);

	String deleteEmpDetails(Long empId);

	Employee fetchEmpDetails(Long empId);

	Employee updateEmpDetails(Employee detachedEmp);

	Employee authenticateEmp(LoginRequestDto dto);

}
