package com.bootapp.rest.restapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Course;
import com.bootapp.rest.restapp.model.Instructor;
import com.bootapp.rest.restapp.model.InstructorCourse;
import com.bootapp.rest.restapp.service.CourseService;
import com.bootapp.rest.restapp.service.InstructorCourseService;
import com.bootapp.rest.restapp.service.InstructorService;

@RestController
@RequestMapping("/api/instructorcourse")
public class InstructorCourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private InstructorService instructorService;
	
	@Autowired
	private InstructorCourseService instructorCourseService;
	
	@PostMapping("/add/{instructorId}/{courseId}")
	public ResponseEntity<String> assignInstructorToCourse(@RequestBody InstructorCourse instructorCourse,
										@PathVariable ("instructorId") int instructorId,
										@PathVariable ("courseId") int courseId) {
		//instructorCourse object 
		//and then taking the instructorid and courseid from the link by using @pathvariable 
		
		//fetching course object from couseid
		Optional<Course> optionalC = courseService.getCourseByID(courseId);
		
		if(!optionalC.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid course id");
		
		Optional<Instructor> optionalI =instructorService.getInstructorById(instructorId);
		if(!optionalI.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid instructor id");
		
		Course course = optionalC.get();
		Instructor instructor = optionalI.get();
		
		instructorCourse.setCourses(course);
		instructorCourse.setInstructors(instructor);
		
		instructorCourseService.insert(instructorCourse);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Instructor added to the course");
		
	}
}
