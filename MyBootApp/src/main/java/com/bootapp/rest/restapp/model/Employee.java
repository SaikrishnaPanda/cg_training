package com.bootapp.rest.restapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootapp.rest.restapp.enums.Gender;

@Entity
@Table(name = "employee") //Optional
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="emp_name")
	private String name;
	
	@Column(name="emp_city")
	private String city;
	
	@Column(name="emp_salary")
	private double salary;
	
	
	@Column(name="emp_joining_date")
	private LocalDate JoiningDate;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	//how to make many to one relationship
	@ManyToOne
	private Department department;
	
	//how to make many to many relationship
	//it creates a weak table which depends on employee and project
	//but it will not work when you want a new column in this table
	//so we have in total three technique to build a M-M relationship
	//explained in instructor and course example in this package only
	
	@ManyToMany
	private List<Project> project;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoiningDate() {
		return JoiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		JoiningDate = joiningDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}
	
	
}
