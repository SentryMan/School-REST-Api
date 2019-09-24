package com.collabera.school.model;

import java.time.LocalDate;

public class Teacher {
	
	private int id;
	private String Fname;
	private String Lname;
	private LocalDate DoB;
	private String subject;
	
	public Teacher() {
		this(-1, "n/a", "n/a", LocalDate.now(), "n/a");
	}
	
	public Teacher(int id, String fname, String lname, LocalDate doB, String subject) {
		super();
		this.id = id;
		Fname = fname;
		Lname = lname;
		DoB = doB;
		this.subject = subject;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public LocalDate getDoB() {
		return DoB;
	}
	public void setDoB(LocalDate doB) {
		DoB = doB;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [id = " + id + ", Fname = " + Fname + ", Lname = " + Lname + ", DoB = " + DoB + ", subject = " + subject
				+ "]";
	}

}
