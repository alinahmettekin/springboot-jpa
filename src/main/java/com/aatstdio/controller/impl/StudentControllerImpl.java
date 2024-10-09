package com.aatstdio.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatstdio.controller.IStudentController;
import com.aatstdio.dto.DtoStudent;
import com.aatstdio.dto.DtoStudentIU;
import com.aatstdio.entities.Student;
import com.aatstdio.services.IStudentService;

@RestController
@RequestMapping("rest/api/student")
public class StudentControllerImpl implements IStudentController {

	@Autowired
	private IStudentService studentService;

	@PostMapping(path = "/save")
	@Override
	public DtoStudent saveStudent(@RequestBody DtoStudentIU dtoStudentIU) {

		return studentService.saveStudent(dtoStudentIU);
	}

	@GetMapping(path = "/list")
	@Override
	public List<Student> getAllStudents() {

		return studentService.getAllStudents();
	}

	@GetMapping(path = "/{id}")
	@Override
	public Student getStudentById(@PathVariable() Integer id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteStudent(@PathVariable() Integer id) {
		studentService.deleteStudent(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public Student updateStudent(@PathVariable() Integer id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

}
