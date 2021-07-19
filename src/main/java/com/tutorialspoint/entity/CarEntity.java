package com.tutorialspoint.entity;

import java.util.GregorianCalendar;

public class CarEntity {

	private int id;
	private double price;
	private GregorianCalendar manufacturingDate1;
	private GregorianCalendar manufacturingDate2;
	private String name1;
	private String name2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public GregorianCalendar getManufacturingDate1() {
		return manufacturingDate1;
	}

	public void setManufacturingDate1(GregorianCalendar manufacturingDate1) {
		this.manufacturingDate1 = manufacturingDate1;
	}

	public GregorianCalendar getManufacturingDate2() {
		return manufacturingDate2;
	}

	public void setManufacturingDate2(GregorianCalendar manufacturingDate2) {
		this.manufacturingDate2 = manufacturingDate2;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}	
}
