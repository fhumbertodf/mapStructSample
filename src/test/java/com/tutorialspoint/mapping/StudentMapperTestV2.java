package com.tutorialspoint.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.tutorialspoint.entity.StudentEntity;
import com.tutorialspoint.entity.SubjectEntity;
import com.tutorialspoint.mapper.StudentMapperV2;
import com.tutorialspoint.model.Student;

public class StudentMapperTestV2 {

	private StudentMapperV2 studentMapper = Mappers.getMapper(StudentMapperV2.class);

	@Test
	public void testEntityToModel() {
		StudentEntity entity = new StudentEntity();
		entity.setClassVal("X");
		entity.setName("John");
		entity.setId(1);

		SubjectEntity subject = new SubjectEntity();
		subject.setName("Computer");
		entity.setSubject(subject);

		Student model = studentMapper.getModelFromEntity(entity);

		assertEquals(entity.getClassVal(), model.getClassName());
		assertEquals(entity.getName(), model.getName());
		assertEquals(entity.getId(), model.getId());
		assertEquals(entity.getSubject().getName(), model.getSubject());
	}

	@Test
	public void testModelToEntity() {
		Student model = new Student();
		model.setId(1);
		model.setName("John");
		model.setClassName("X");
		model.setSubject("Science");
		StudentEntity entity = studentMapper.getEntityFromModel(model);
		assertEquals(entity.getClassVal(), model.getClassName());
		assertEquals(entity.getName(), model.getName());
		assertEquals(entity.getId(), model.getId());
		assertEquals(entity.getSubject().getName(), model.getSubject());
	}
}