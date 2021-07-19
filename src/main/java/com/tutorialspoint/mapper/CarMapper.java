package com.tutorialspoint.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tutorialspoint.entity.CarEntity;
import com.tutorialspoint.model.Car;

/*
 * MapStruct handles conversion of numbers to String in required format seamlessly. 
 * We can pass the required format as numberFormat during @Mapping annotation. 
 * For example, consider a case where an amount stored in numbers is to be shown in currency format.
 */
@Mapper(imports = UUID.class)
public interface CarMapper {

	@Mapping(source = "price", target = "price", numberFormat = "$#.00")
	@Mapping(source = "manufacturingDate1", target = "manufacturingDate1", dateFormat = "dd.MM.yyyy")
	@Mapping(target = "manufacturingDate2", expression = "java(getManufacturingDate(carEntity.getManufacturingDate2()))")
	@Mapping(target = "brand", constant = "BMW")
	@Mapping(source = "name1", target = "name1", defaultValue = "Sample")
	@Mapping(source = "name2", target = "name2", defaultExpression = "java(UUID.randomUUID().toString())")
	Car getModelFromEntity(CarEntity carEntity);

	default String getManufacturingDate(GregorianCalendar manufacturingDate) {
		Date d = manufacturingDate.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(d);
	}

	List<String> getListOfStrings(List<Integer> listOfIntegers);

	List<Car> getCars(List<CarEntity> carEntities);
}
