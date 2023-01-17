package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Instructor;
import com.bootapp.rest.restapp.model.InstructorCourse;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	void save(InstructorCourse instructorCourse);

}
