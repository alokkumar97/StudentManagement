package com.imaginnovate.sm.request;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public class StudentRequest {

	@NotBlank(message = "Invalid Name: Empty name")
	@NotNull(message = "Invalid Name: Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
	private String firstName;
	
	@NotBlank(message = "Invalid Name: Empty name")
	@NotNull(message = "Invalid Name: Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
    private String lastName;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;
    private String section;
    private String gender;
    

	@NotNull(message = "Invalid Input: Mark1 is NULL")
	@Min(value = 0, message = "Invalid Mark1: Must be of 0 or greater" )
	@Max(value = 100, message = "Invalid Mark1: Must be of 100 or less" )
    private int marks1;
    
   
	@NotNull(message = "Invalid Input: Mark2 is NULL")
	@Min(value = 0, message = "Invalid Mark2: Must be of 0 or greater" )
	@Max(value = 100, message = "Invalid Mark2: Must be of 100 or less" )
    private int marks2;
    
   
	@NotNull(message = "Invalid Input: Mark3 is NULL")
    @Min(value = 0, message = "Invalid Mark3: Must be of 0 or greater" )
	@Max(value = 100, message = "Invalid Mark3: Must be of 100 or less" )
    private int marks3;
    
    
    //Getter and Setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	public StudentRequest(String firstName, String lastName, LocalDate dob, String section, String gender, int marks1,
			int marks2, int marks3) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.section = section;
		this.gender = gender;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}
	public StudentRequest() {
	}
    
    
}
