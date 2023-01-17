package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CourseRepository;
import com.bootapp.rest.restapp.model.Course;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public void postCourse(Course course) {
		courseRepository.save(course);
		
	}

	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	public Optional<Course> getCourseByID(int id) {
		// TODO Auto-generated method stub
		Optional optional =  courseRepository.findById(id);
		return optional;
	}

}
