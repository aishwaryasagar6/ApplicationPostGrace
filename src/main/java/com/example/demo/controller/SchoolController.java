package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository;
import com.example.demo.model.School;
import com.example.demo.model.repository.SchoolRepository;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class SchoolController {

	@Autowired
	private SchoolRepository schoolRepository;
	
	// get all employees
	@GetMapping("/schools")
	public List<School> getAllSchools(){
		return schoolRepository.findAll();
	}		
	
	// create employee rest api 
	@PostMapping("/schools")
	public School createSchool(@RequestBody School school) {
		return schoolRepository.save(school);
	}
	
	// get employee by id rest api
	@GetMapping("/schools/{id}")
	public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
		School school= schoolRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("school not exist with id :" + id));
		
		return ResponseEntity.ok(school);
	}
	
	// update employee rest api
	
	@PutMapping("/schools/{id}")
	public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School schoolDetails){
		School school = schoolRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("school not exist with id :" + id));
		
		//employee.setFirstName(employeeDetails.getFirstName());
		//employee.setLastName(employeeDetails.getLastName());
		//employee.setEmailId(employeeDetails.getEmailId());
		school.setFirstName(schoolDetails.getFirstName());
		school.setLastName(schoolDetails.getLastName());
		school.setEmailId(schoolDetails.getEmailId());
		
		School updatedSchool = schoolRepository.save(school);
		return ResponseEntity.ok(updatedSchool);
		
	}
	
	// delete employee rest api
	@DeleteMapping("/school/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSchool(@PathVariable Long id){
		School school= schoolRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		schoolRepository.delete(school);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}