package com.aatstdio.controller;

import java.util.List;

import com.aatstdio.dto.DtoStudent;
import com.aatstdio.dto.DtoStudentIU;

public interface IStudentController {

	public DtoStudent saveStudent(DtoStudentIU student);

	public List<DtoStudent> getAllStudents();

	public DtoStudent getStudentById(Integer id);

	public void deleteStudent(Integer id);

	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
