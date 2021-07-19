package com.tutorialspoint.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tutorialspoint.entity.StudentEntity;
import com.tutorialspoint.model.Student;

/*
 * MapStruct handles direct fields mapping easily. 
 * For example, a Student with section as private property and StudentEntity with section as public property. 
 * To have both getter/setter mapping, a property should be public. 
 * In case of public final, only getter method will be present for mapping.
 * Now create a mapper interface. We'll use @InheritInverseConfiguration annotation to copy reverse configuration now.
 */

@Mapper
public interface StudentMapperV3 {
	
	@Mapping(target = "className", source = "classVal")
	@Mapping(target = "subject", source = "subject.name")
	Student getModelFromEntity(StudentEntity studentEntity);

	@InheritInverseConfiguration
	StudentEntity getEntityFromModel(Student student);
}
