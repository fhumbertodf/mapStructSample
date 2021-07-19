package com.tutorialspoint.entity;

public class StudentEntity {

	private int id;
	private String name;
	private String classVal;
	private SubjectEntity subject;
	public String section;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassVal() {
		return classVal;
	}

	public void setClassVal(String classVal) {
		this.classVal = classVal;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}
}
