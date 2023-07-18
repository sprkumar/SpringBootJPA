package com.ra.rk.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ra.rk.dto.ResponseDto;
import com.ra.rk.exception.ResourceNotFoundException;
import com.ra.rk.model.Employee;
import com.ra.rk.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PostMapping("/addAllEmployee")
	public List<Employee> addAllEmployee(@RequestBody List<Employee> employees) {
		return employeeRepository.saveAll(employees);
	}

	@GetMapping("/getEmployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") Long id) {
		return employeeRepository.findById(id);
	}

	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(Employee employee) {
		return employeeRepository.findAll();
	}

	@PutMapping("updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee emp = employeeRepository.findById(employee.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Data not found  for id:", employee.getId()));
		emp.setName(employee.getName());
		emp.setAddress(employee.getAddress());
		emp.setEmail(employee.getEmail());
		emp.setContact(employee.getContact());
		return employeeRepository.save(emp);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		employeeRepository.deleteById(id);
		return "Succsessfully deleted!";
	}
}
