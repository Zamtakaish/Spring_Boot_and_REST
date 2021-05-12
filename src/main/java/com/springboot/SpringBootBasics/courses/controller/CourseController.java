package com.springboot.SpringBootBasics.courses.controller;

import com.springboot.SpringBootBasics.courses.bean.Course;
import com.springboot.SpringBootBasics.courses.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/courses/{id}")
    public Course getCourseDetails(@PathVariable long id) {
        Optional<Course> course = repository.findById(id);
        if (course.isEmpty()){
            throw new RuntimeException("Course not found with id " + id);
        }
        return course.get();
        //return Arrays.asList(new Course(1, "Learn Microservices", "Zamtakaish"));
    }

    @PostMapping("/courses")
    public void createCourse(@RequestBody Course course){
        repository.save(course);
    }

    @PutMapping("/courses/{id}")
    public void updateCourse(@PathVariable long id, @RequestBody Course course){
        repository.save(course);
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable long id){
        repository.deleteById(id);
    }
}
