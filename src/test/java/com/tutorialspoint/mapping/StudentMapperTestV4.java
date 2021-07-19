package com.tutorialspoint.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.tutorialspoint.entity.StudentEntity;
import com.tutorialspoint.mapper.StudentMapperV4;
import com.tutorialspoint.model.Student;

public class StudentMapperTestV4 {
	
   private StudentMapperV4 studentMapper = Mappers.getMapper(StudentMapperV4.class);
   
   @Test
   public void testEntityToModel() {
      StudentEntity entity = new StudentEntity();
      entity.setName("John");
      entity.setId(1);

      Student model = studentMapper.getModelFromEntity(entity);
      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
   }
   @Test
   public void testModelToEntity() {
      Student.Builder builder = Student.builder().id(1).name("John");
      Student model = builder.create();
      StudentEntity entity = studentMapper.getEntityFromModel(model);

      assertEquals(entity.getName(), model.getName());
      assertEquals(entity.getId(), model.getId());
   }
}
