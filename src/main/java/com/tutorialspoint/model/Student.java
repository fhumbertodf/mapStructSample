package com.tutorialspoint.model;

public class Student {

	private int id;
	private String name;
	private String className;
	private String subject;
	private String section;
	
	public Student() {
		
	}

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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	// Builder

	protected Student(Student.Builder builder) {
		this.name = builder.name;
		this.id = builder.id;
		this.className = builder.className;
		this.subject = builder.subject;
		this.section = builder.section;
	}

	public static Student.Builder builder() {
		return new Student.Builder();
	}

	public static class Builder {
		private String name;
		private int id;
		private String className;
		private String subject;
		private String section;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder className(String className) {
			this.className = className;
			return this;
		}

		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}

		public Builder section(String section) {
			this.section = section;
			return this;
		}

		public Student create() {
			return new Student(this);
		}
	}
}