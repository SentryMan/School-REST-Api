package com.collabera.school.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.collabera.school.model.Student;
import com.collabera.school.service.StudentService;

@RestController
public class StudentController{
	
	@Autowired
	StudentService service;
	
	@GetMapping("/api/students")
	public List<Student> getstudent(){
		
		return service.getAllStudents();	
	}

	@GetMapping("/api/students/{studentid}")
	public Student getStudent(@PathVariable String studentid) {
	
	return service.getStudent(Integer.parseInt(studentid));
	}	
	
	@GetMapping("/api/students/major/{major}")
	public List<Student> getStudentByMajor(@PathVariable String major) {
	
	return service.getStudentByMajor(major);
	}
	
	@PostMapping("/api/students")
	public ResponseEntity<String> addStudent(@RequestBody Student student) throws URISyntaxException{
		
		Student newStudent = service.addStudent(student.getFname(), student.getLname(), student.getDoB(), student.getMajor());
		System.out.println(newStudent);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newStudent.getId()).toUri();
        
        return ResponseEntity.created(location).header("student", newStudent.getId() + "")
                .body(newStudent.getFname() + " " + newStudent.getLname());
	}
	
	@PutMapping("/api/students")
		public void updateStudent(@RequestBody Student student){
		
		service.updateStudent(student);
	}
	
	@DeleteMapping("/api/students/{id}")
	public void deleteStudents(@PathVariable int id) {
		
		service.deleteStudent(id);
		
	}
}
