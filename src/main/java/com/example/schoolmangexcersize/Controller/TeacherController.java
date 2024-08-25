package com.example.schoolmangexcersize.Controller;

import com.example.schoolmangexcersize.Model.Teacher;
import com.example.schoolmangexcersize.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.ok("Teacher added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@Valid @RequestBody Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.ok("Teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok("Teacher deleted");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }
}
