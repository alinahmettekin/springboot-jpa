package com.aatstdio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aatstdio.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
