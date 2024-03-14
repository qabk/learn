package com.example.learnjava.services;

import com.example.learnjava.models.Student;
import com.example.learnjava.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    final private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
     Optional<Student> emailStudents =  studentRepository.findStudentByEmail(student.getEmail());
     if(emailStudents.isPresent()){
         throw new IllegalStateException("email has existed");
     }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {

        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
              "student with id " + id + " does not exists");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
      Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalStateException(
              "student with id " + id + " does not exists"));
        System.out.println(student.getId());
        student.setName(name);
        student.setEmail(email);
        System.out.println(student.getName());
        studentRepository.save(student);

    }

    public void updateStudentPatch(Long id, String name, String email) {
    }
}
