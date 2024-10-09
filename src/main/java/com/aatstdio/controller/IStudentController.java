package com.aatstdio.controller;

import java.util.List;

import com.aatstdio.dto.DtoStudent;
import com.aatstdio.dto.DtoStudentIU;
import com.aatstdio.entities.Student;

public interface IStudentController {

	public DtoStudent saveStudent(DtoStudentIU student);

	public List<Student> getAllStudents();

	public Student getStudentById(Integer id);

	public void deleteStudent(Integer id);

	public Student updateStudent(Integer id, Student student);
}
