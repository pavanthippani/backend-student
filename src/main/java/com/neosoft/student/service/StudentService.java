package com.neosoft.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.student.model.Student;
import com.neosoft.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	//@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	//@Override
	public Optional<Student> findById(int id) { 
		// TODO Auto-generatedmethod stub 
	return studentRepository.findById(id); 
	}
	 

	//@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	
	  //@Override
	  public void delete(int id) { // TODO Auto-generated method stub
		  studentRepository.deleteById(id);
	  }
	 
}
