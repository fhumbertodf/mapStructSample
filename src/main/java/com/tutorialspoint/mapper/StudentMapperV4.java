package com.tutorialspoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tutorialspoint.entity.StudentEntity;
import com.tutorialspoint.model.Student;

/*
 * MapStruct allows to use Builders. We can use Builder frameworks or can use our custom builder. 
 * In below example, we are using a custom builder. 
 */

@Mapper
public interface StudentMapperV4 {
		
   @Mapping(target = "subject", source = "subject.name")	
   Student getModelFromEntity(StudentEntity studentEntity);
   
   @Mapping(target="id", source="id")
   @Mapping(target="name", source="name")
   @Mapping(target = "subject.name", source = "subject")
   StudentEntity getEntityFromModel(Student student);
}
