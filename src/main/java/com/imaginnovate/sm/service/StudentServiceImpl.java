package com.imaginnovate.sm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.sm.model.Student;
import com.imaginnovate.sm.repository.StudentRepository;
import com.imaginnovate.sm.request.StudentRequest;
import com.imaginnovate.sm.request.UpdateMarksRequest;
import com.imaginnovate.sm.validation.StudentValidation;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentValidation studvalidation;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public boolean createStudent(StudentRequest studentReq)  {
		
		if(!studvalidation.isValidStudent(studentReq)) {
			return false;
		}
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

	@Override
	public List<Student> getAllStudent(Long id) {
		return null;
	}

	@Override
	public String updateStudent(Long id, UpdateMarksRequest request) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            return "Student is not present !";
        }
        
        Student student = optionalStudent.get();
        if(!studvalidation.isValidMarks(request.getMarks1(), request.getMarks2(), request.getMarks3())) {
		return "Input mark is not valid! ";
        }
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
