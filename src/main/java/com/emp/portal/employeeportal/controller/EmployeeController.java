package com.emp.portal.employeeportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.portal.employeeportal.entity.Employee;
import com.emp.portal.employeeportal.exception.EmployeeNotFoundException;
import com.emp.portal.employeeportal.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		
		try {
			empService.addEmployee(employee);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		
	}


	@PutMapping("/employee/{id}/{salary}")
	public ResponseEntity<?> updateEmpSalary(@PathVariable(name = "id") Integer id, @PathVariable(name = "salary") Double salary) {
		
		try {
			empService.updateEmpSalary(id, salary);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/employee/{deptId}")
	public ResponseEntity<?> getEmployeeByDeptId(@PathVariable(name = "deptId") Integer deptId) {
		
		List<Employee> theEmployee = empService.getEmployeeByDeptId(deptId);
		
		if (!theEmployee.isEmpty()) {
			return new ResponseEntity<List<Employee>>(empService.getEmployeeByDeptId(deptId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
					
	}	

}
