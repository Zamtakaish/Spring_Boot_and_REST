package com.springboot.SpringBootBasics.courses.controller;

import com.springboot.SpringBootBasics.courses.bean.Course;
import com.springboot.SpringBootBasics.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository repository;

    //http://localhost:8080/courses
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return repository.findAll();

        /*return Arrays.asList(new Course(1, "Learn Microservices", "Zamtakaish"),
                new Course(2, "Full Stack with Angular and React", "Zamtakaish"));*/
    }

    @GetMapping("/courses/1")
    public List<Course> getCourseDetails() {
        return Arrays.asList(new Course(1, "Learn Microservices", "Zamtakaish"));
    }
}
