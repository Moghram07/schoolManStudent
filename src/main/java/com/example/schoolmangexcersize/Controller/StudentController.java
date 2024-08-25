package com.example.schoolmangexcersize.Controller;

import com.example.schoolmangexcersize.Model.Student;
import com.example.schoolmangexcersize.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok("Student added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok("Student updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted");
    }

    @PutMapping("/{studentId}/assign/{courseId}")
    public ResponseEntity assignCourse(@PathVariable Integer studentId, @PathVariable Integer courseId) {
        studentService.assignCourse(studentId, courseId);
        return ResponseEntity.ok("Course assigned");
    }
}
