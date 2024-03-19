package com.jnholfert.jhdemo.controller;
import com.jnholfert.jhdemo.model.Student;
import com.jnholfert.jhdemo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {
  @Autowired
  StudentService studentService;

  @GetMapping("/students")
  public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String surname) {
    try {
      List<Student> students = new ArrayList<Student>();

      if (surname == null)
        studentService.findAll().forEach(students::add);
      else
        studentService.findByNameContaining(surname).forEach(students::add);

      if (students.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(students, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/students/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
    Student student = studentService.findById(id);

    if (student != null) {
      return new ResponseEntity<>(student, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/students")
  public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    try {
      Student _student = studentService.save(new Student(student.getFirstname(), student.getSurname(), student.getDateOfBirth(), student.getSex(), student.getGender(), student.getPhonenumber()));
      return new ResponseEntity<>(_student, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/students/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
    Student _student = studentService.findById(id);

    if (_student != null) {
      _student.setFirstname(student.getFirstname());
      _student.setSurname(student.getSurname());
      _student.setDateOfBirth(student.getDateOfBirth());
      _student.setSex(student.getSex());
      _student.setGender(student.getGender());
      _student.setPhonenumber(student.getPhonenumber());
      return new ResponseEntity<>( studentService.save(_student), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/students/{id}")
  public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
    try {
      studentService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


}
