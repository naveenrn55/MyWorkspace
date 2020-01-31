/**
 * 
 */
package com.mindtree.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 *
 */
public class Employee {

	private Integer ssn;
	private String firstName;
	private String lastName;
	private Employee manager;
	private Set<Employee> employees=new HashSet<Employee>();
	public Integer getSsn() {
		return ssn;
	}
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
