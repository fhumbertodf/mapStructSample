package com.tutorialspoint.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.stream.Stream;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;

import com.tutorialspoint.entity.CarEntity;
import com.tutorialspoint.entity.OrderType;
import com.tutorialspoint.model.Car;
import com.tutorialspoint.model.PlacedOrderType;

@Mapper(uses=DateMapper.class)
public interface UtilityMapper {
	@MapMapping(valueDateFormat = "dd.MM.yyyy")
	Map<String, String> getMap(Map<Long, GregorianCalendar> source);

	Stream<String> getStream(Stream<Integer> source);

	@ValueMapping(source = "EXTRA", target = "SPECIAL")
	PlacedOrderType getEnum(OrderType order);

	CarEntity getCarEntity(Car car) throws ParseException;

	default Car getCar(CarEntity entity) {
		Car car = new Car();
		car.setId(entity.getId());
		car.setName1(entity.getName1());
		return car;
	}
}

class DateMapper {
	public String asString(GregorianCalendar date) {
		return date != null ? new SimpleDateFormat("yyyy-MM-dd").format(date.getTime()) : null;
	}

	@SuppressWarnings("deprecation")
	public GregorianCalendar asDate(String date) throws ParseException {
		Date date1 = date != null ? new SimpleDateFormat("yyyy-MM-dd").parse(date) : null;
		if (date1 != null) {
			return new GregorianCalendar(date1.getYear(), date1.getMonth(), date1.getDay());
		}
		return null;
	}
}
