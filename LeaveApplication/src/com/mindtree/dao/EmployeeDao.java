/**
 * 
 */
package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Employee;
import com.mindtree.vo.EmployeeLeaveVO;

/**
 * 
 *
 */
public interface EmployeeDao {

	public List<Employee> getAllManagers();
	public List<Employee> getAllEmployees();
	public List<EmployeeLeaveVO> getEmployeesUnderManager(Integer managerId);
} 
