package com.example.demo.db3.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.db3.model.Student;
import com.example.demo.db3.service.StudentService;
@RestController
@RequestMapping("/api")

public class StudentController {
	 @Autowired
	    private StudentService studentService;

	    // Endpoint to save a user
	    @PostMapping("/student")
	    public ResponseEntity<Student> save(@RequestBody Student studentD){
	        Student student = studentService.saveStudent(studentD);
	        return new ResponseEntity<>(student, HttpStatus.OK);
	    }
}
