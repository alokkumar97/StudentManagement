package com.imaginnovate.sm.validation;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import com.imaginnovate.sm.model.Student;

@Component
public class StudentValidation {

	// Age validation
	public boolean isValidStudentAge(Student student) {		
		LocalDate currentDate = LocalDate.now();
		int dob = Period.between(student.getDob(),currentDate).getYears();
        if (dob <= 15 || dob > 20) {
            return false;
        }
		return true;
	}
	
}
