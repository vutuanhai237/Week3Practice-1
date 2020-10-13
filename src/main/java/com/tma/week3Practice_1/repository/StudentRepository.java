package com.tma.week3Practice_1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tma.week3Practice_1.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
