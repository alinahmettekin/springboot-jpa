package com.aatstdio.services;

import java.util.List;

import com.aatstdio.entities.Student;

public interface IStudentService {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(Integer id);

	public void deleteStudent(Integer id);
}
