package com.bootapp.rest.restapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Instructor;
import com.bootapp.rest.restapp.service.InstructorService;


@RequestMapping("/api/instructor")
@RestController
public class InstructorController {
	
	@Autowired
	private InstructorService instructorservice;
	
/*	@PostMapping("/api/instructor/add")
	public ResponseEntity<String> postInstructor(@RequestBody Instructor instructor){
		
		instructorservice.postInstructor(instructor);
		
		return ResponseEntity.status(HttpStatus.OK).body("Instructor Posted..");
	}
	@GetMapping("/api/instructor/get")
	public List<Instructor> getInstructor(){ 
		
		return instructorservice.getInstructor();
	}
	*/
	//==============================
	//sirs work(Example)
	
	//get service first and autowire it..(done)
	//Instructor POST API
	@PostMapping("/add")
	public ResponseEntity<String> postInstructor(@RequestBody Instructor instructor) {
		//first ask if the instructor has any dependancy (like if it injected any other class)
		//if no dependancy>>> add request body of only instructor
		
		instructorservice.insertEmployee(instructor);
		
		return ResponseEntity.status(HttpStatus.OK).body("Instructor posted in Db");
		
	}
	
	//get ALL API
	@GetMapping("/getall")
	public List<Instructor> getAllInstructors() {//------only getting data
		//if service giving it nust be kept in list
		List<Instructor> list =instructorservice.getAllInstructors();
		return list;
	}
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Object> getInstructorById(@PathVariable ("id") int id) {//------getting data by specific data
		Optional<Instructor> optional =  instructorservice.getInstructorById(id); // in can be correct id or may be wrong so we need to keep it in Optional
		
		if(!optional.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid id given");
		Instructor instructor = optional.get();//els get it
		return ResponseEntity.status(HttpStatus.OK).body(instructor);
		//IMP>>>> as both returns are returning different type so lets make the return type Object
		
	}
}
