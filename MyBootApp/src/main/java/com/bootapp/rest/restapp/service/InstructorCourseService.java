package com.bootapp.rest.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.InstructorRepository;
import com.bootapp.rest.restapp.model.InstructorCourse;



@Service
public class InstructorCourseService {
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	public void insert(InstructorCourse instructorCourse) {
		// TODO Auto-generated method stub
		instructorRepository.save(instructorCourse);
	}

}
