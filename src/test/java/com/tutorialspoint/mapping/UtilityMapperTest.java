package com.tutorialspoint.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.tutorialspoint.entity.CarEntity;
import com.tutorialspoint.entity.OrderType;
import com.tutorialspoint.mapper.UtilityMapper;
import com.tutorialspoint.model.Car;
import com.tutorialspoint.model.PlacedOrderType;

public class UtilityMapperTest {
	private UtilityMapper utilityMapper = Mappers.getMapper(UtilityMapper.class);

	@Test
	public void testMapMapping() {
		Map<Long, GregorianCalendar> source = new HashMap<>();
		source.put(1L, new GregorianCalendar(2015, 3, 5));

		Map<String, String> target = utilityMapper.getMap(source);
		assertEquals("2015-04-05", target.get("1"));
	}

	@Test
	public void testGetStream() {
		Stream<Integer> numbers = Arrays.asList(1, 2, 3, 4).stream();

		Stream<String> strings = utilityMapper.getStream(numbers);
		assertEquals(4, strings.count());
	}

	@Test
	public void testGetEnum() {
		PlacedOrderType placedOrderType = utilityMapper.getEnum(OrderType.EXTRA);
		PlacedOrderType placedOrderType1 = utilityMapper.getEnum(OrderType.NORMAL);
		PlacedOrderType placedOrderType2 = utilityMapper.getEnum(OrderType.STANDARD);
		assertEquals(PlacedOrderType.SPECIAL.name(), placedOrderType.name());
		assertEquals(PlacedOrderType.NORMAL.name(), placedOrderType1.name());
		assertEquals(PlacedOrderType.STANDARD.name(), placedOrderType2.name());
	}

	@SuppressWarnings("unused")
	@Test
	   public void testGetCarEntity() {
	      Car car = new Car();
	      car.setId(1);
	      car.setManufacturingDate1("11/10/2020");
	      boolean exceptionOccured = false;
	      try {
	        
			CarEntity carEntity = utilityMapper.getCarEntity(car);
	      } catch (ParseException e) {
	         exceptionOccured = true;
	      }
	      assertTrue(exceptionOccured);
	   }
	   @Test
	   public void testGetCar() {
	      CarEntity entity = new CarEntity();
	      entity.setId(1);
	      entity.setName1("ZEN");
	      Car car = utilityMapper.getCar(entity);

	      assertEquals(entity.getId(), car.getId());
	      assertEquals(entity.getName1(), car.getName1());		
	   }
}