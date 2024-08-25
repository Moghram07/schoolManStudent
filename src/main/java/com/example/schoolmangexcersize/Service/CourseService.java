package com.example.schoolmangexcersize.Service;

import com.example.schoolmangexcersize.Model.Course;
import com.example.schoolmangexcersize.Model.Teacher;
import com.example.schoolmangexcersize.Repository.CourseRepository;
import com.example.schoolmangexcersize.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course) {
        Course c = courseRepository.findCourseById(id);
        if(c == null) {
            throw new RuntimeException("Course not found");
        }
        c.setName(course.getName());
        c.setTeacher(course.getTeacher());
        courseRepository.save(c);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }

    public void assignTeacher(Integer courseId, Integer teacherId) {
        Course c = courseRepository.findCourseById(courseId);
        Teacher t = teacherRepository.findTeacherById(teacherId);
        if(c == null || t == null) {
            throw new RuntimeException("can not assign teacher");
        }
        c.setTeacher(t);
        courseRepository.save(c);
    }

    public String getCourseById(Integer id) {
        Course c = courseRepository.findCourseById(id);
        if(c == null || c.getTeacher() == null) {
            throw new RuntimeException("Course not found");
        }

        return c.getTeacher().getName();
    }

}
