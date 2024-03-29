package com.mahezh.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mahezh.student.model.Student;
import com.mahezh.student.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {
	

	public StudentService studentService;
	
	public StudentController (StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//Create API to POST student details  
	@PostMapping("/create")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	
	//Create API to Retrieve (Read) all students.
	@GetMapping("/show_all_students")
	public List <Student> getAll(){
		return studentService.getAllStudents();
	}


	//Create API to get specific student by the id
	
	@GetMapping("/show_student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID){
		return new ResponseEntity<>(studentService.getStudentById(studentID), HttpStatus.OK);
	}
	
	
	//Create API to Update specific student by the id
	@PutMapping("/update_student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id")long id 
				,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK );
		
	}
	
	//Create API to delete an Student 
		@DeleteMapping("/delete_student/{id}")
		public ResponseEntity<String> deleteStudent (@PathVariable("id")long id){
			studentService.deleteStudent(id);
			
			return new ResponseEntity<String>("Student is deleted sucessfully now!...", HttpStatus.OK);
			
		}
}
