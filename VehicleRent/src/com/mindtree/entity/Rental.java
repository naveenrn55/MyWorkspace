/**
 * 
 */
package com.mindtree.entity;

import java.util.Date;


public class Rental {

	private int rentalId;
	private Vehicle vehicle;
	private String customersName;
	private Date fromDate;
	private Date toDate;
	private double totalRent;
	public int getRentalId() {
		return rentalId;
	}
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public String getCustomersName() {
		return customersName;
	}
	public void setCustomersName(String customersName) {
		this.customersName = customersName;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public double getTotalRent() {
		return totalRent;
	}
	public void setTotalRent(double totalRent) {
		this.totalRent = totalRent;
	}
	
	
}
