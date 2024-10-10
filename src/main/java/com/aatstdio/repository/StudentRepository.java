package com.aatstdio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aatstdio.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	// @Query(value = "from Student", nativeQuery = false)
	@Query(value = "select * from student.student", nativeQuery = true)
	List<Student> findAllStudent();
	
	@Query(value = "from Student s WHERE s.id = :id")
	Optional<Student> findStudentById(Integer id);
}
