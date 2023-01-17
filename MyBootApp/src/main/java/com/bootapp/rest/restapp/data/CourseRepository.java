package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.rest.restapp.model.Course;

public interface CourseRepository extends JpaRepository<Course ,Integer> {

}
