/**
 * 
 */
package com.mindtree.entity;

/**
 * @author Banu Prakash
 *
 * © 2011 MindTree Limited
 */
public class Employee {
	private int employeeId;
	private String employeeName;
	private String email;
	private String departmentName;
	
	
	/**
	 * 
	 */
	public Employee() {
		super();
	}
	
	
	/**
	 * @param employeeId
	 * @param employeeName
	 * @param email
	 * @param departmentName
	 */
	public Employee(int employeeId, String employeeName, String email,
			String departmentName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.departmentName = departmentName;
	}


	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
