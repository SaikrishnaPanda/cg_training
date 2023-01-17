package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.InstructorRepository;
import com.bootapp.rest.restapp.model.Instructor;
@Service
public class InstructorService {
	
	//first create a repository as interface...
	//and call it here and autowire it
	@Autowired
	private InstructorRepository instructorRepository;

	public void insertEmployee(Instructor instructor) {
		// for insertion we have areadmade method as save()
		instructorRepository.save(instructor);
		
	}

	public List<Instructor> getAllInstructors() {
		// also have a ready made method as findAll()
		
		return instructorRepository.findAll();
	}

	public Optional<Instructor> getInstructorById(int id) {
		// ready made method is there as findById(id) and make it optional
		Optional optional = instructorRepository.findById(id);
		return optional;
	}

/*	public void postInstructor(Instructor instructor) {
//		// TODO Auto-generated method stub
//		instructorRepository.save(instructor);
//	}
//
//	public List<Instructor> getInstructor() {
//		// TODO Auto-generated method stub
//		List<Instructor> list = instructorRepository.findAll();
//		return list;
//	}
*/
}
