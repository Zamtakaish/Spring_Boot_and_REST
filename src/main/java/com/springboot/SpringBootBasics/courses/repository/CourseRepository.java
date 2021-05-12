package com.springboot.SpringBootBasics.courses.repository;

import com.springboot.SpringBootBasics.courses.bean.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
