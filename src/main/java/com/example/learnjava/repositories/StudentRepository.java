package com.example.learnjava.repositories;

import com.example.learnjava.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    // SELECT * FROM student WHERE email = ?

    @Query("SELECT s FROM Student s WHERE  s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
