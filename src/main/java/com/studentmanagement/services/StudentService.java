package com.studentmanagement.services;

import java.util.List;

import com.studentmanagement.entities.Student;

public interface StudentService {
   List<Student> getAllStudents();
   
   Student saveStudent(Student student);
   
   Student getStudentById(Long id);
   
   Student updateStudent(Student student);
   
   void deleteStudent(Long id);
}
