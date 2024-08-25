package com.example.schoolmangexcersize.Controller;

import com.example.schoolmangexcersize.Model.Course;
import com.example.schoolmangexcersize.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.ok("Course added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @Valid @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.ok("Course updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted");
    }

    @PutMapping("/assignTeacher/{courseId}/{teacherId}")
    public ResponseEntity assignTeacher(@PathVariable Integer courseId, @PathVariable Integer teacherId) {
        courseService.assignTeacher(courseId, teacherId);
        return ResponseEntity.ok("Teacher assigned");
    }

    @GetMapping("/getTeacher/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

}
