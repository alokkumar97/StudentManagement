package com.imaginnovate.sm.validation;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import com.imaginnovate.sm.model.Student;
import com.imaginnovate.sm.request.StudentRequest;

@Component
public class StudentValidation {


	public boolean isValidStudent(StudentRequest student) {
		/*if(student.getFirstName().length() < 3 || student.getLastName().length() < 3) {
			return false;
		}*/
		
		LocalDate currentDate = LocalDate.now();
		int dob = Period.between(student.getDob(),currentDate).getYears();
        if (dob <= 15 || dob > 20) {
            return false;
        }
		
		/*String section = student.getSection();
		if(!section.equals("A") && !section.equals("B") && !section.equals("C")) {
			return false;
		}
		
		String gender = student.getGender();
		if(!gender.equals("M") && !gender.equals("F")) {
			return false;
		}*/
		return true;
	}
	
	public boolean isValidMarks(int marks1, int marks2, int marks3) {
		if (marks1 < 0 || marks1 > 100 || marks2 < 0 || marks2 > 100 || marks3 < 0 || marks3 > 100) {
            return false;
        }
		return true;
	}
}
