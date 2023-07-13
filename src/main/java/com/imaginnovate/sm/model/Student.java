package com.imaginnovate.sm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 // Validate Names
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
 	// Validate Section and Gender
 	@Pattern(regexp = ("[A-C]"),message = "Invalid Section: Section must be 'A' or 'B' or 'C' ")
     private String section;
 	@Pattern(regexp = ("[M,F,T]"),message = "Invalid Gender: Gender must be 'M' or 'F' or 'T' ")
     private String gender;
     
 	//Validates Marks
 	@NotNull(message = "Invalid Input: Mark1 is NULL")
 	@Min(value = 0, message = "Invalid Mark1: Must be equals to 0 or >=100" )
 	@Max(value = 100, message = "Invalid Mark1: Must be equals to 100  or <=0" )
     private int marks1;
     
    
 	@NotNull(message = "Invalid Input: Mark2 is NULL")
 	@Min(value = 0, message = "Invalid Mark2: Must be equals to 0 or >=100" )
 	@Max(value = 100, message = "Invalid Mark2: Must be equals to 100  or <=0" )
     private int marks2;
     
    
 	@NotNull(message = "Invalid Input: Mark3 is NULL")
     @Min(value = 0, message = "Invalid Mark3: Must be equals to 0 or >=100" )
 	@Max(value = 100, message = "Invalid Mark3: Must be equals to 100  or <=0" )
     private int marks3;
 	
    private int total;
    private double average;
    private String result;

    // Constructors

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dob, String section, String gender,
                   int marks1, int marks2, int marks3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.section = section;
        this.gender = gender;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", section=" + section + ", gender=" + gender + ", marks1=" + marks1 + ", marks2=" + marks2
				+ ", marks3=" + marks3 + ", total=" + total + ", average=" + average + ", result=" + result + "]";
	}
    
    
}

