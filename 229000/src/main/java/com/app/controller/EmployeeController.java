package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.LoginRequestDto;
import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	public EmployeeController() {
	}

	@GetMapping
	public List<Employee> getAllEmps() {
		return empService.getAllEmpDetails();
	}

	@PostMapping
	public Employee saveEmpDetails(@RequestBody Employee transientEmp) {
		return empService.addEmpDetails(transientEmp);

	}

	@DeleteMapping("/{empId}")
	public ApiResponse deleteEmpDetails(@PathVariable Long empId) {
		return new ApiResponse(empService.deleteEmpDetails(empId));
	}

	@GetMapping("/{empId}")
	public Employee getEmpDetails(@PathVariable Long empId) {
		return empService.fetchEmpDetails(empId);
	}

	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee detachedEmp) {
		return empService.updateEmpDetails(detachedEmp);
	}

	@PostMapping("/signin")
	public Employee validateEmployee(@RequestBody LoginRequestDto dto) {
		return empService.authenticateEmp(dto);
	}

}
