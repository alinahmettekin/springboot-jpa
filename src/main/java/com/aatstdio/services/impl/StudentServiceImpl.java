package com.aatstdio.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aatstdio.dto.DtoStudent;
import com.aatstdio.dto.DtoStudentIU;
import com.aatstdio.entities.Student;
import com.aatstdio.repository.StudentRepository;
import com.aatstdio.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {

		DtoStudent dtoResponse = new DtoStudent();
		Student student = new Student();

		BeanUtils.copyProperties(dtoStudentIU, student);
		Student dbStudent = studentRepository.save(student);

		BeanUtils.copyProperties(dbStudent, dtoResponse);
		return dtoResponse;

	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoResponseList = new ArrayList<>();
		List<Student> dbStudents = studentRepository.findAllStudent();

		for (Student student : dbStudents) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoResponseList.add(dtoStudent);
		}
		return dtoResponseList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoResponse = new DtoStudent();
		Optional<Student> optional = studentRepository.findStudentById(id);
		if (optional.isPresent()) {
			BeanUtils.copyProperties(optional.get(), dtoResponse);
			return dtoResponse;
		}
		return dtoResponse;
	}

	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {

		DtoStudent dtoResponse = new DtoStudent();

		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			Student dbStudent = optional.get();

			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

			Student updatedStudent = studentRepository.save(dbStudent);
			BeanUtils.copyProperties(updatedStudent, dtoResponse);

			return dtoResponse;
		}
		return dtoResponse;
	}

}
