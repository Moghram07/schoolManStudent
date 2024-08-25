package com.example.schoolmangexcersize.Repository;

import com.example.schoolmangexcersize.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);

}
