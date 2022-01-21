package com.neosoft.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	
}
