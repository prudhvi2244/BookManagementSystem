package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepository;
@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository srepo;
	@Override
	public Student saveStudent(Student student) {
		return srepo.save(student);
	}

}
