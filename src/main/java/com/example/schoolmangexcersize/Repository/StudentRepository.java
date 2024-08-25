package com.example.schoolmangexcersize.Repository;

import com.example.schoolmangexcersize.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentById(Integer id);

}
