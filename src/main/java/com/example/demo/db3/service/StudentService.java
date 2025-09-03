package com.example.demo.db3.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.db3.model.Student;
import com.example.demo.db3.repository.StudentRepository;
@Service
public class StudentService {

	@Autowired
    private StudentRepository studentRepository;

    // Service method to save a user
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
