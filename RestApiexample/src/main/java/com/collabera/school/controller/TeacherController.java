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

import com.collabera.school.model.Teacher;
import com.collabera.school.service.TeacherService;

@RestController
public class TeacherController{
	
	@Autowired
	TeacherService service;
	
	@GetMapping("/api/teachers")
	public List<Teacher> getTeacher(){
		
		return service.getAllTeachers();	
	}

	@GetMapping("/api/teachers/{id}")
	public Teacher getTeacher(@PathVariable String id) {
	
	return service.getTeacher(Integer.parseInt(id));
	}	
	
	@PostMapping("/api/teachers")
	public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) throws URISyntaxException{
		
		Teacher newTeacher = service.addTeacher(teacher.getFname(), teacher.getLname(), teacher.getDoB(), teacher.getSubject());
		System.out.println(newTeacher);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newTeacher.getId()).toUri();
        
        return ResponseEntity.created(location).header("teacher", newTeacher.getId() + "")
                .body(newTeacher.getFname() + " " + newTeacher.getLname());
	}
	
	@PutMapping("/api/teachers")
		public void updateStudent(@RequestBody Teacher teacher){
		
		service.updateteacher(teacher);
	}
	
	@DeleteMapping("/api/teachers/{id}")
	public void deleteTeacher(@PathVariable int id) {
		
		service.deleteTeacher(id);
		
	}
}