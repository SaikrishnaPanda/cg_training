package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.InstructorCourse;

public interface InstructorCourseRepository extends JpaRepository<InstructorCourse, Integer> {

}
