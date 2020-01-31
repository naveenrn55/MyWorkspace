/**
 * 
 */
package com.mindtree.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.exception.DaoException;

public abstract class BaseDao {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/vehiclerent";
	private static final String USER_NAME="root";
	private static final String PASSWORD="Welcome123";
	
	public BaseDao() throws DaoException
	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			throw new DaoException("Unable to load the driver",e);
		}
	}
	public Connection getConnection() throws DaoException{
		try {
			return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new DaoException("Unable to get Connection",e);
		}
	}
	public void closeStatement(Statement smt) throws DaoException
	{
		if(smt!=null){
			try {
				smt.close();
			} catch (SQLException e) {
				//e.printStackTrace();
				throw new DaoException("Unable to close Statement",e);
			}
		}
	}
	public void closeConnection(Connection con) throws DaoException
	{
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				//e.printStackTrace();
				throw new DaoException("Unable to close Statement",e);
			}
		}
	}
}
