package com.collabera.school.model;

import java.time.LocalDate;

public class Student {

	private int id;
	private String Fname;
	private String Lname;
	private LocalDate DoB;
	private String major;

	public Student() {
		this(-1, "n/a", "n/a", LocalDate.now(), "n/a");
	}

	public Student(int id, String fname, String lname, LocalDate doB, String major) {
		super();
		this.id = id;
		Fname = fname;
		Lname = lname;
		DoB = doB;
		this.major = major;
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", DoB=" + DoB + ", major=" + major
				+ "]";
	}

}
