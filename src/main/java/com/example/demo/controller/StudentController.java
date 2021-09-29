package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.IStudentService;

import io.swagger.annotations.Api;


@RestController
@RequestMapping(value = "/student")
@Api(value = "Student Rest Controller",description = "REST API's Related To Student Entity")
public class StudentController {
	
	@Autowired
	private IStudentService sservice;

	
	@PostMapping(value = "/saveStudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student)
	{
		Student savedstudent=sservice.saveStudent(student);
		return new ResponseEntity<Student>(savedstudent,HttpStatus.CREATED);
	}
	
}
