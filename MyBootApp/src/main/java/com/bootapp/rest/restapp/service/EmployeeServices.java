package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.EmployeeRepository;
import com.bootapp.rest.restapp.model.Employee;
@Service
public class EmployeeServices {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void postEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}
	
	
	public List<Employee> getEmployeeByDepartmentId(int did) {
		List<Employee> list = employeeRepository.findAll(); 
		
		List<Employee> filteredlist = list.stream()
											.filter(e->e.getDepartment().getId()== did)
											.collect(Collectors.toList());
		return filteredlist;
	}


	public List<Employee> getEmployeesBySalaryAndCity(double salary, String city) {
		// TODO Auto-generated method stub
		List<Employee> list = employeeRepository.findAll();
		List<Employee> filteredlist = list.stream()
										.filter(e->e.getSalary() > salary)
										.filter(e->e.getCity().equals(city))
										.collect(Collectors.toList());
		
		return filteredlist;
	}

}
