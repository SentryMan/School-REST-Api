package com.collabera.school.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.collabera.school.model.Student;

@Service
public class StudentService {
	
	private static List<Student> students = new ArrayList<Student>();
	private static int idCounter = 1;
	
	static {
		students.add(new Student(idCounter++, "Jack", "Johnson", 
				LocalDate.of(1998, 5, 22), "Computer Science"));
		
		students.add(new Student(idCounter++, "Cave", "Johnson", 
				LocalDate.of(1995, 7, 13), "Portals"));
		
		students.add(new Student(idCounter++, "Mario", "Mario", 
				LocalDate.of(1698, 5, 22), "Gae Bolg"));
		
		students.add(new Student(idCounter++, "Irish", "Hercules", 
				LocalDate.of(1798, 5, 22), "Gaelic magic"));
	}
	
	//crud
	
	//create
	public Student addStudent(String fName, String lName, LocalDate dob, String major) {
		
		Student student = new Student(idCounter++, fName,lName, dob, major);
		students.add(student);
		return student;
		
	}
	
	//read
	public List<Student> getAllStudents(){
		return students;
	}
	
	public Student getStudent(int id) {
		Student student = null;
		for (int s = 0; s < students.size(); s++) {
			if(students.get(s).getId() == id) {
				student = students.get(s);
				break;
			}
			
		}
		return student;
	}
	
	public List<Student> getStudentByMajor(String major) {
		List<Student> studentMajor = new ArrayList<Student>();
		
		for (int s = 0; s < students.size(); s++) {
			if(students.get(s).getMajor().toLowerCase().equals(major.toLowerCase())) {
				studentMajor.add(students.get(s));
				break;
			}
			
		}
		return studentMajor;
	}
	
	//update
	public void updateStudent(Student student) {
		Student studentToUpdate = getStudent(student.getId());
		studentToUpdate.setFname(student.getFname());
		studentToUpdate.setLname(student.getLname());
		studentToUpdate.setDoB(student.getDoB());
		studentToUpdate.setMajor(student.getMajor());
		
	}
	
	//delete
	public void deleteStudent(int id){
		
		for (int s = 0; s < students.size(); s++) {
			if(students.get(s).getId() == id) {
				students.remove(students.get(s));
				break;
			}
			
		}
		
	}
}
