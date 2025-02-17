package com.studentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
