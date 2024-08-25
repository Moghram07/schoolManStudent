package com.example.schoolmangexcersize.Service;

import com.example.schoolmangexcersize.ApiResponse.ApiResponse;
import com.example.schoolmangexcersize.Model.Teacher;
import com.example.schoolmangexcersize.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher t = teacherRepository.findTeacherById(id);
        if(t == null) {
            throw new ApiResponse("Teacher not found");
        }
        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());

        teacherRepository.save(t);
    }

    public void deleteTeacher(Integer id) {
        Teacher t = teacherRepository.findTeacherById(id);
        if(t == null) {
            throw new ApiResponse("Teacher not found");
        }
        teacherRepository.delete(t);
    }

    public Teacher getTeacherById(Integer id) {
        Teacher t = teacherRepository.findTeacherById(id);
        if(t == null) {
            throw new ApiResponse("Teacher not found");
        }
        return t;
    }
}
