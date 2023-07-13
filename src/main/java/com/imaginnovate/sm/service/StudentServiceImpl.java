package com.imaginnovate.sm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.sm.exception.StudentAlreadyExistsException;
import com.imaginnovate.sm.exception.StudentNotFoundException;
import com.imaginnovate.sm.model.Student;
import com.imaginnovate.sm.repository.StudentRepository;
import com.imaginnovate.sm.request.UpdateMarksRequest;
import com.imaginnovate.sm.validation.StudentValidation;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentValidation studvalidation;
	
	@Autowired
	private StudentRepository studentRepository;

	// save student details
	@Override
	public boolean createStudent(Student studentReq)  {
		// Verify If Student Exist or Not
		List<Student> list = studentRepository.findAll();
		for(Student student : list) {
			if(student.getFirstName().equals(studentReq.getFirstName()) && 
					student.getLastName().equals(studentReq.getLastName()) && student.getGender().equals(studentReq.getGender())) {
				throw new StudentAlreadyExistsException();
			}
		}
		// Validate Age 
		if(!studvalidation.isValidStudentAge(studentReq)) {
			return false;
		}
		// Save Student Details
		Student student = new Student();
		BeanUtils.copyProperties(studentReq, student);
		
		int total = student.getMarks1() + student.getMarks2() + student.getMarks3();
        double average = total / 3.0;
        
        String result = (student.getMarks1() >= 35 && student.getMarks2() >= 35 && student.getMarks3() >= 35) ? "Pass" : "Fail";
        
        student.setTotal(total);
        student.setAverage(average);
        student.setResult(result);
        
        studentRepository.save(student);
		return true;
	}
	// Get all or By id
	@Override
	public List<Student> getAllStudentByid(Long id) {
		if(studentRepository.findById(id).isEmpty()) {
			throw new StudentNotFoundException();
		}
		if(null != id) {
			return studentRepository.findAllById(id);
		}else
		return studentRepository.findAll();
	}
	// Update
	@Override
	public String updateStudent(Long id, UpdateMarksRequest request) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
        	throw new StudentNotFoundException();
        }
        
        Student student = optionalStudent.get();
        
        student.setMarks1(request.getMarks1());
        student.setMarks2(request.getMarks2());
        student.setMarks3(request.getMarks3());
        
        int total = request.getMarks1() + request.getMarks2() + request.getMarks3();
        double average = total / 3.0;
        String result = (request.getMarks1() >= 35 && request.getMarks2() >= 35 && request.getMarks3() >= 35) ? "Pass" : "Fail";
        
        student.setTotal(total);
        student.setAverage(average);
        student.setResult(result);
        
        studentRepository.save(student);
        return "success";
	}

}
