package com.shoeclub;

public class Shoe {

	private int shoeID = 0;
	private String manufacturer = null;
	private String shoeType = null;
	private double shoeSize = 0.0;
	private double shoePrice = 0.0;


	public Shoe() {
		super();
	}


	public int getShoeID() {
		return shoeID;
	}


	public void setShoeID(int shoeID) {
		this.shoeID = shoeID;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getShoeType() {
		return shoeType;
	}


	public void setShoeType(String shoeType) {
		this.shoeType = shoeType;
	}


	public double getShoeSize() {
		return shoeSize;
	}


	public void setShoeSize(double shoeSize) {
		this.shoeSize = shoeSize;
	}


	public double getShoePrice() {
		return shoePrice;
	}


	public void setShoePrice(double shoePrice) {
		this.shoePrice = shoePrice;
	}


	@Override
	public String toString() {
		return "ShoeClub [shoeID=" + shoeID + ", manufacturer=" + manufacturer + ", shoeType=" + shoeType
				+ ", shoeSize=" + shoeSize + ", shoePrice=" + shoePrice + "]";
	}





}

