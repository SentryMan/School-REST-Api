package com.collabera.school.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.collabera.school.model.Teacher;

@Service
public class TeacherService {
	
	private static List<Teacher> teachers = new ArrayList<Teacher>();
	private static int idCounter = 1;
	
	static {
		teachers.add(new Teacher(idCounter++, "Kiritsigu", "Emiya", 
				LocalDate.of(1998, 5, 22), "How to kill a mage"));
		
		teachers.add(new Teacher(idCounter++, "Sigurd", "Seigfreid", 
				LocalDate.of(1995, 7, 13), "Monster slaying"));
		
		teachers.add(new Teacher(idCounter++, "Shishou", "Scathath", 
				LocalDate.of(1698, 5, 22), "Gae Bolg"));
		
		teachers.add(new Teacher(idCounter++, "Chiron", "greek", 
				LocalDate.of(1798, 5, 22), "Greek magicks"));
	}
	
	//crud
	
	//create
	public Teacher addTeacher(String fName, String lName, LocalDate dob, String subject) {
		
		Teacher teacher = new Teacher(idCounter++, fName,lName, dob, subject);
		teachers.add(teacher);
		return teacher;
		
	}
	
	//read
	public List<Teacher> getAllTeachers(){
		return teachers;
	}
	
	public Teacher getTeacher(int id) {
		Teacher teacher = null;
		for (int s = 0; s < teachers.size(); s++) {
			if(teachers.get(s).getId() == id) {
				teacher = teachers.get(s);
				break;
			}
			
		}
		return teacher;
	}
	
	
	//update
	public void updateteacher(Teacher teacher) {
		Teacher teacherToUpdate = getTeacher(teacher.getId());
		teacherToUpdate.setFname(teacher.getFname());
		teacherToUpdate.setLname(teacher.getLname());
		teacherToUpdate.setDoB(teacher.getDoB());
		teacherToUpdate.setSubject(teacher.getSubject());
		
	}
	
	//delete
	public void deleteTeacher(int id){
		
		for (int s = 0; s < teachers.size(); s++) {
			if(teachers.get(s).getId() == id) {
				teachers.remove(teachers.get(s));
				break;
			}
			
		}
		
	}
}
