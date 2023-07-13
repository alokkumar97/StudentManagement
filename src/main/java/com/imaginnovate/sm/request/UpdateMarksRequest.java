package com.imaginnovate.sm.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateMarksRequest {

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

	public UpdateMarksRequest(int marks1, int marks2, int marks3) {
		super();
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}

	public UpdateMarksRequest() {
	}
    
}
