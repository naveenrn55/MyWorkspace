/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Rental;
import com.mindtree.entity.Vehicle;
import com.mindtree.exception.DaoException;

/**
 * @author M1018442
 *
 */
public interface VehicleDao {

	public void addVehicle(Vehicle vehicle) throws DaoException;
	public void bookVehicle(Rental rentedVehicle) throws DaoException;
	public List<Vehicle> getBookingReport();
	public List<String> getRegisterNumbers(String category) throws DaoException;
	public double getRent(String regNo) throws DaoException;
}
