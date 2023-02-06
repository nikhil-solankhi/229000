package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Employee;
import java.lang.String;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByEmailAndPassword(String email, String password);
}
