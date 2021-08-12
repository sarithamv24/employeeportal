package com.emp.portal.employeeportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.portal.employeeportal.entity.Employee;
import com.emp.portal.employeeportal.exception.EmployeeAlreadyExistsException;
import com.emp.portal.employeeportal.exception.EmployeeNotFoundException;
import com.emp.portal.employeeportal.repository.EmployeeDAO;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO empDAO;
	
	
	public boolean addEmployee(Employee employee) throws EmployeeAlreadyExistsException {
		
		boolean status = true;
		final Optional<Employee> theEmployee = empDAO.findById(employee.getId());
		if (theEmployee.isPresent()) {
			throw new EmployeeAlreadyExistsException("Employee already exists!");
		}
		empDAO.save(employee);
		return status;
	}

	
	public Employee updateEmpSalary(Integer empId, Double salary) throws EmployeeNotFoundException {
		
		Employee employee = empDAO.findById(empId).orElse(null);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Not Found!");
		}
		employee.setSalary(salary);
		empDAO.save(employee);
		return employee;
		
	}
	
	public List<Employee> getEmployeeByDeptId(Integer deptId) {
		
		return empDAO.getEmployeeByDeptId(deptId);
		
	}

	
}
