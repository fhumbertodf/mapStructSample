package com.tutorialspoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tutorialspoint.entity.AddressEntity;
import com.tutorialspoint.entity.StudentEntity;
import com.tutorialspoint.model.DeliveryAddress;

/*
 * We can add map multiple objects as well. 
 * For Example, we want to get a DeliveryAddress Object using Student and Address object.
 * Now create a mapper interface which can map two objects into one.
 */

@Mapper
public interface DeliveryAddressMapper {

	@Mapping(source = "student.name", target = "name")
	@Mapping(source = "address.houseNo", target = "houseNumber")
	DeliveryAddress getDeliveryAddress(StudentEntity student, AddressEntity address);
}
