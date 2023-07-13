package com.imaginnovate.sm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.sm.model.Student;
import com.imaginnovate.sm.request.StudentRequest;
import com.imaginnovate.sm.request.UpdateMarksRequest;
import com.imaginnovate.sm.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<?> createStudent(@RequestBody @Valid StudentRequest student){
		boolean status = studentService.createStudent(student);
		if(status != true) {
			return  ResponseEntity.badRequest().body("Invalid Age: Age should be equals to 15 or <= 20");
		}
		return ResponseEntity.ok("Successfully register.");
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudentMarks(@PathVariable Long id, @RequestBody UpdateMarksRequest request){
		String status = studentService.updateStudent(id, request);
		if(status != "success") {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok("Successfully Updated !");	
	}
}
