package com.biblioteca.rest.bidireccional.apiInstructor.repository;

import com.biblioteca.rest.bidireccional.apiInstructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

}
