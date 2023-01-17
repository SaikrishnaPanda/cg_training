package com.bootapp.rest.restapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Department;
import com.bootapp.rest.restapp.model.Employee;
import com.bootapp.rest.restapp.service.DepartmentService;
import com.bootapp.rest.restapp.service.EmployeeServices;

@RestController
public class EmployeeController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeServices employeeService;
	
	@GetMapping("/api/hello")
	public String sayHello () {
		return "hello spring boot";
	}
	@PostMapping("/api/employee/add/{did}")
	public ResponseEntity<String> postEmployee(@RequestBody Employee employee,  @PathVariable("did") int did) {
		
				//Fetch Department Object based on did. 
				Department department = departmentService.getDepartmentById(did);

				//Attach department object to employee
				employee.setDepartment(department);

				employee.setJoiningDate(LocalDate.now());

				//save the employee object
				employeeService.postEmployee(employee); 
		
		return ResponseEntity.status(HttpStatus.OK).body("Employee Posted..");
	}
	
	//get API
	
	//display all employee on the basis of the department id
	@GetMapping("/api/employee/department/{did}")
	public List<Employee> showEmployeeByDeptId(@PathVariable("did") int did){
		List<Employee> list = employeeService.getEmployeeByDepartmentId(did);
		return list;
	}
	//make api
	
	//
	
	@GetMapping("/api/employee/salary/city/{salary}/{city}")
	public List<Employee> getEmployeesBySalaryAndCity(
			@PathVariable("salary") double salary,
			@PathVariable("city") String city){
		List<Employee> list = employeeService.getEmployeesBySalaryAndCity(salary,city);
		return list;
	}
}
	

