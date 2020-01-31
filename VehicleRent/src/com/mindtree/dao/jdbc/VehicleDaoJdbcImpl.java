/**
 * 
 */
package com.mindtree.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.dao.VehicleDao;
import com.mindtree.entity.Rental;
import com.mindtree.entity.Vehicle;
import com.mindtree.exception.DaoException;


public class VehicleDaoJdbcImpl extends BaseDao implements VehicleDao {

	
	private static final String GET_REG_NO="select reg_no from vehicle where category=?";
	private static final String GET_RENT="select daily_rent from vehicle where reg_no=?";
	private static final String BOOK_VEHICLE="insert into rental(rid,cust_name,from_date,to_date,total_rent,reg_no) values(0,?,?,?,?,?)";
	
	public VehicleDaoJdbcImpl() throws DaoException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.mindtree.dao.VehicleDao#addVehicle(com.mindtree.entity.Vehicle)
	 */
	@Override
	public void addVehicle(Vehicle vehicle) throws DaoException {
		
		

	}

	/* (non-Javadoc)
	 * @see com.mindtree.dao.VehicleDao#bookVehicle(com.mindtree.entity.Rental)
	 */
	@Override
	public void bookVehicle(Rental rentedVehicle) throws DaoException {
			

	}

	/* (non-Javadoc)
	 * @see com.mindtree.dao.VehicleDao#getBookingReport()
	 */
	@Override
	public List<Vehicle> getBookingReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getRegisterNumbers(String category) throws DaoException {
		
		Connection con=getConnection();
		PreparedStatement ps=null;
		List<String> regList=new ArrayList<String>();
		try {
			
			ps=con.prepareStatement(GET_REG_NO);
			ps.setString(1, category);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				regList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new DaoException("Unable to get the information", e);
		}finally{
			closeStatement(ps);
			closeConnection(con);
		}
		return regList;
	}

	@Override
	public double getRent(String regNo) throws DaoException {
		
		Connection con=getConnection();
		PreparedStatement ps=null;
		double rent=0;
		try {
			ps=con.prepareStatement(GET_RENT);
			ps.setString(1, regNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				rent=rs.getDouble(1);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new DaoException("Unable to get the information",e);
		}
		
		return rent;
	}

}
