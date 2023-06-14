package com.student.services;

import java.util.List;

import com.student.bean.Student;

public interface StudentService {

		public Student addStudent(Student student);
		public List<Student>getAllStudents();
		public Student getStudentById(Long id);
		public Student updateStudentById(Student student,Long id);
		public void deleteStudentById(Long id);
		
}
