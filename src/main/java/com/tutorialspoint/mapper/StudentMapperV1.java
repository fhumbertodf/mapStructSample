package com.tutorialspoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tutorialspoint.entity.StudentEntity;
import com.tutorialspoint.model.Student;

/*
 * Using mapstruct is very easy. To create a mapper use org.mapstruct.Msapper annotation on an interface.
 */

@Mapper
public interface StudentMapperV1 {
	
   @Mapping(target="className", source="classVal")
   @Mapping(target = "subject", source = "subject.name")
   Student getModelFromEntity(StudentEntity student);

   @Mapping(target="classVal", source="className")
   @Mapping(target = "subject.name", source = "subject")
   StudentEntity getEntityFromModel(Student student);
}
