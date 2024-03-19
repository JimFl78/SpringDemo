package com.jnholfert.jhdemo.service;

import com.jnholfert.jhdemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

  static List<Student> students = new ArrayList<Student>();
  static long id = 0;

  public List<Student> findAll() {
    return students;
  }

  public List<Student> findByNameContaining(String surname) {
    return students.stream().filter(student -> student.getSurname().contains(surname)).toList();
  }

  public Student findById(long id) {
    return students.stream().filter(student -> id == student.getId()).findAny().orElse(null);
  }

  public Student save(Student student) {
    // update student
    if (student.getId() != 0) {
      long _id = student.getId();

      for (int x = 0; x < students.size(); x++)
        if (_id == students.get(x).getId()) {
          students.set(x, student);
          break;
        }

      return student;
    }

    // create new Student
    student.setId(++id);
    students.add(student);
    return student;
  }

  public void deleteById(long id) {
    students.removeIf(student -> id == student.getId());
  }

}
