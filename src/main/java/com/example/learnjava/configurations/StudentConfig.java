package com.example.learnjava.configurations;

import com.example.learnjava.models.Student;
import com.example.learnjava.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (
            StudentRepository studentRepository
    ){
        // sql commands to database
        return args -> {
            Student aStudent =  new Student(
 "a", LocalDate.of(2004,1,1),"a@gmail.com"
      );

            Student bStudent =  new Student(
 "b" ,LocalDate.of(2004,1,1),"b@gmail.com"
            );
            studentRepository.saveAll(List.of(aStudent,bStudent));
        };

    }
}
