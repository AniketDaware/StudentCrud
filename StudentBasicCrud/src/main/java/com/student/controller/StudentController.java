package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.student.bean.Student;
import com.student.services.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	
	@Autowired	
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public ResponseEntity<Student>addStudent(@RequestBody Student student){
		Student saveStudent = studentService.addStudent(student);
		return new ResponseEntity<Student>(saveStudent,HttpStatus.CREATED);
		
	}
	

	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudents = studentService.getAllStudents();
		return new ResponseEntity <List<Student>>(allStudents,HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student>getStudentById(@PathVariable("id")Long id){
		
		Student studentById = studentService.getStudentById(id);
		
		return new ResponseEntity<Student>(studentById,HttpStatus.OK);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudentById(@RequestBody Student student,@PathVariable Long id) 
	{
		
	    Student updatedStudent = studentService.updateStudentById(student, id);
	    return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
		
	}

	@DeleteMapping("/{id}") 
	public void deleteStudentById(@PathVariable("id") Long id) 
	{
		studentService.deleteStudentById(id);
		
		
		
	}
	
	
}
