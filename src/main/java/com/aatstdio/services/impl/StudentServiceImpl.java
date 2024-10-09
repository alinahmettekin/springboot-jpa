package com.aatstdio.services.impl;

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
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteStudent(Integer id) {
		Student dbStudent = getStudentById(id);

		if (dbStudent != null) {
			studentRepository.delete(dbStudent);
		}
	}

	@Override
	public Student updateStudent(Integer id, Student updatedStudent) {
		Student dbStudent = getStudentById(id);

		if (dbStudent != null) {
			dbStudent.setFirstName(updatedStudent.getFirstName());
			dbStudent.setLastName(updatedStudent.getLastName());
			dbStudent.setBirthOfDate(updatedStudent.getBirthOfDate());

			return studentRepository.save(dbStudent);
		}
		return null;
	}

}
