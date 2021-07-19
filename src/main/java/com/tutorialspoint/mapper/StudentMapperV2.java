package com.tutorialspoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tutorialspoint.entity.StudentEntity;
import com.tutorialspoint.model.Student;

/*
 * We can add custom methods as well to the Mapper created using org.mapstruct.Mapper annotation. 
 * We can create abstract class as well intead of an Interface. 
 * Mapstruct automatically creates the corresponding mapper class.
 * Now create a default conversion method in interface.
 */

@Mapper
public interface StudentMapperV2 {
	
	default Student getModelFromEntity(StudentEntity studentEntity) {
		Student student = new Student();
		student.setId(studentEntity.getId());
		student.setName(studentEntity.getName());
		student.setClassName(studentEntity.getClassVal());
		student.setSubject(studentEntity.getSubject().getName());
		return student;
	}

	@Mapping(target = "classVal", source = "className")
	@Mapping(target = "subject.name", source = "subject")
	StudentEntity getEntityFromModel(Student student);
}