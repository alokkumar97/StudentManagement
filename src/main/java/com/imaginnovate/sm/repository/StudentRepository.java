package com.imaginnovate.sm.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginnovate.sm.model.Student;

public interface StudentRepository extends JpaRepository<Student, Serializable> {

	List<Student> findAllById(Long id);

	List<Student> findAllByFirstNameContaining(String firstName);

}
