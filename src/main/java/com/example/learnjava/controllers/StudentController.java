package com.example.learnjava.controllers;

import com.example.learnjava.models.Student;
import com.example.learnjava.repositories.StudentRepository;
import com.example.learnjava.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private final StudentService studentService;



    @GetMapping
    public List<Student> helloWorld() {
        return  studentService.getStudent();
    }


    @PostMapping
    public void addNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path ="{studentId}")
    public  void updateStudent(@PathVariable("studentId" ) Long id,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email){
        studentService.updateStudent(id,name,email);
    }

    @PatchMapping(path ="{studentId}")
    public void updateStudentPatch(@PathVariable("studentId" ) Long id,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String email)
    {
        studentService.updateStudentPatch(id,name,email);
    }

}
