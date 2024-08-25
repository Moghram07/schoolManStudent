package com.example.schoolmangexcersize.Repository;

import com.example.schoolmangexcersize.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findTeacherById(Integer id);
 //   Teacher findTeacherByC
}
