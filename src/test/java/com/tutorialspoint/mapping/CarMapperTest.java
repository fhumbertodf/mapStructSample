package com.tutorialspoint.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.tutorialspoint.entity.CarEntity;
import com.tutorialspoint.mapper.CarMapper;
import com.tutorialspoint.model.Car;

public class CarMapperTest {

	private CarMapper carMapper = Mappers.getMapper(CarMapper.class);

	@Test
	public void testEntityToModel() {
		CarEntity entity = new CarEntity();
		entity.setPrice(345000);
		entity.setId(1);
		entity.setManufacturingDate1(new GregorianCalendar(2015, 3, 5));
		entity.setManufacturingDate2(new GregorianCalendar(2015, 3, 5));

		CarEntity entity1 = new CarEntity();
		entity1.setPrice(445000);
		entity1.setId(2);
		entity1.setManufacturingDate1(new GregorianCalendar(2015, 3, 5));
		entity1.setManufacturingDate2(new GregorianCalendar(2015, 3, 5));

		List<CarEntity> carEntities = Arrays.asList(entity, entity1);

		Car model = carMapper.getModelFromEntity(entity);
		assertEquals(model.getPrice(), "$345000,00");
		assertEquals(entity.getId(), model.getId());
		assertEquals("05.04.2015", model.getManufacturingDate1());
		assertEquals("05.04.2015", model.getManufacturingDate2());
		assertEquals("BMW", model.getBrand());
		assertEquals("Sample", model.getName1());
		assertNotNull(model.getName2());

		List<Integer> list = Arrays.asList(1, 2, 3);
		List<String> listOfStrings = carMapper.getListOfStrings(list);
		List<Car> listOfCars = carMapper.getCars(carEntities);

		assertEquals(3, listOfStrings.size());
		assertEquals(2, listOfCars.size());
	}
}
