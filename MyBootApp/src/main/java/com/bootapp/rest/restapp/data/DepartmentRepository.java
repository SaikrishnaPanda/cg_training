package com.bootapp.rest.restapp.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	

}
