package com.biblioteca.rest.bidireccional.apiInstructor.controllers;

import com.biblioteca.rest.bidireccional.apiInstructor.entity.Instructor;
import com.biblioteca.rest.bidireccional.apiInstructor.repository.InstructorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;


    @GetMapping
    public ResponseEntity<Page<Instructor>> getAllInstructors(Pageable pageable){

        return new ResponseEntity<>(instructorRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Integer id){

        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);

        if(optionalInstructor.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalInstructor.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Instructor> addInstructor(@Valid @RequestBody Instructor instructor){

        Instructor instuctorSaved = instructorRepository.save(instructor);

        return new ResponseEntity<>(instuctorSaved,HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Integer id, @Valid @RequestBody Instructor instructor){

        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);

        if(optionalInstructor.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        instructor.setId(id);
        return new ResponseEntity<>(instructorRepository.save(instructor),HttpStatus.OK);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Instructor> deleteInstructor(@PathVariable Integer id){

        Optional<Instructor> optionalInstructor = instructorRepository.findById(id);

        if(optionalInstructor.isEmpty()){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        instructorRepository.delete(optionalInstructor.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
