package com.example.schoolmangexcersize.Service;

import com.example.schoolmangexcersize.Model.Course;
import com.example.schoolmangexcersize.Model.Student;
import com.example.schoolmangexcersize.Repository.CourseRepository;
import com.example.schoolmangexcersize.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student) {
        Student s = studentRepository.findStudentById(id);
        if(s == null) {
            throw new RuntimeException("Student not found");
        }
        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
        studentRepository.save(s);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public void assignCourse(Integer studentId, Integer courseId) {
        Student s = studentRepository.findStudentById(studentId);
        Course c = courseRepository.findCourseById(courseId);
        if(s == null || c == null) {
            throw new RuntimeException("can not assign course");
        }
        s.getCourses().add(c);
        c.getStudents().add(s);
        studentRepository.save(s);
        courseRepository.save(c);
    }
}
