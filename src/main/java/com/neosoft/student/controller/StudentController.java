package com.neosoft.student.controller;

	import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.neosoft.student.model.Student;
import com.neosoft.student.service.StudentService;
	@CrossOrigin()
	@RestController
	@RequestMapping("/api")
	public class StudentController {
		
		@Autowired
		private StudentService studentService;
		
		
		@GetMapping(value="/students")
		List<Student> getAll(){
			return studentService.getAllStudents();
		}	
		@PostMapping(value="/student")
		ResponseEntity<?> createProduct(@Valid @RequestBody Student student) {
			Student addedStudent = studentService.save(student);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							                .path("/{id}")
							                .buildAndExpand(addedStudent.getId())
							                .toUri();
			return ResponseEntity.ok().body(student);//ResponseEntity.created(location).build();
		}
		
		
		  @PutMapping(value="/students/{id}") 
		  ResponseEntity<Student> updateEmployee(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Student student) {		  
		  Optional<Student> stu = studentService.findById(id);
		  student.setId(stu.get().getId());
		  studentService.save(stu.get()); 
		  return  ResponseEntity.ok().body(student);
		  
		  }
		 
		
		
		  @DeleteMapping(value="/students/{id}") 
		  ResponseEntity<String> deleteEmployee( @PathVariable("id") @Min(1) int id) { 
		  Optional<Student> stu = studentService.findById(id);
		  studentService.delete(stu.get().getId()); 
		  return ResponseEntity.ok().body("Student with ID : "+id+" deleted with success!");
		  
		  }
		 

	}
	

