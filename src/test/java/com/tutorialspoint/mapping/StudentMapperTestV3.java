package com.tutorialspoint.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.tutorialspoint.entity.StudentEntity;
import com.tutorialspoint.entity.SubjectEntity;
import com.tutorialspoint.mapper.StudentMapperV3;
import com.tutorialspoint.model.Student;

public class StudentMapperTestV3 {
	
   private StudentMapperV3 studentMapper = Mappers.getMapper(StudentMapperV3.class);
   
   @Test
   public void testEntityToModel() {
      StudentEntity entity = new StudentEntity();
      entity.setClassVal("X");
      entity.setName("John");
      entity.setId(1);
      entity.section = "A";
      SubjectEntity subject = new SubjectEntity();
      subject.setName("Computer");
      entity.setSubject(subject);
      Student model = studentMapper.getModelFromEntity(entity);
      assertEquals(entity.getClassVal(), model.getClassName());
      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
      assertEquals(entity.getSubject().getName(), model.getSubject());
      assertEquals(entity.section, model.getSection());	  
   }
   @Test
   public void testModelToEntity() {
      Student model = new Student();
      model.setId(1);
      model.setName("John");
      model.setClassName("X");
      model.setSubject("Science");
      model.setSection("A");
      StudentEntity entity = studentMapper.getEntityFromModel(model);

      assertEquals(entity.getClassVal(), model.getClassName());
      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
      assertEquals(entity.getSubject().getName(), model.getSubject());
      assertEquals(entity.section, model.getSection());
   }
}