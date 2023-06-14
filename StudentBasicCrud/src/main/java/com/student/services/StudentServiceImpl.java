package com.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.student.bean.Student;
import com.student.exception.ResourceNotFound;
import com.student.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public Student addStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		
		return studentRepo.findById(id).orElseThrow(() -> new ResourceNotFound("StudentNot Found"));
		
	}

	@Override
	public Student updateStudentById(Student student, Long id) {
		if(!studentRepo.existsById(id)) {
			throw new ResourceNotFound("Student Not Found");
			
		}
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		if(!this.studentRepo.existsById(id)) 
		{
			throw new ResourceNotFound("Student Not Found");
			
		}
		else {
			this.studentRepo.deleteById(id);
		}

	}

}
