package com.imaginnovate.sm.service;

import java.util.List;

import com.imaginnovate.sm.model.Student;
import com.imaginnovate.sm.request.StudentRequest;
import com.imaginnovate.sm.request.UpdateMarksRequest;

public interface StudentService {

	public boolean createStudent(StudentRequest student);
	public List<Student> getAllStudent(Long id);
	public String updateStudent(Long id, UpdateMarksRequest request);
}
