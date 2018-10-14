package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping(value = "/college/students")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	

	@GetMapping(value = "/findall")
	public List<Student> findAll()
	{
		return studentRepository.findAll();
	}
	
	@PostMapping(value = "/load")
	public List<Student> persist(@RequestBody Student students)
	{
		studentRepository.save(students);
		return studentRepository.findAll();
	}
	
}
