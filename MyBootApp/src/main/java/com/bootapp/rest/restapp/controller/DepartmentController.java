package com.bootapp.rest.restapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Department;
import com.bootapp.rest.restapp.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/api/department/add")
	public ResponseEntity<String> postDepartment(@RequestBody Department department) {
		departmentService.postEmployee(department);
		return ResponseEntity.status(HttpStatus.OK).body("Department Posted..");
	}
}
