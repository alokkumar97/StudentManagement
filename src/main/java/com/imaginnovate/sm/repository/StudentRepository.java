package com.imaginnovate.sm.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginnovate.sm.model.Student;

public interface StudentRepository extends JpaRepository<Student, Serializable> {

}
