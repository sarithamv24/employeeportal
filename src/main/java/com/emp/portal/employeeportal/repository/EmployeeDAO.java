package com.emp.portal.employeeportal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emp.portal.employeeportal.entity.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer>{

	List<Employee> getEmployeeByDeptId(Integer deptId);
}
