/**
 * 
 */
package com.mindtree.entity;

import java.util.Date;

/**
 * 
 *
 */
public class Leave {

	private Integer leaveId;
	private Employee employee;
	private LeaveType leaveType;
	private Date startDate;
	private Date endDate;
	private Integer noOfDays;
	private Integer isApproved;
	
	public Integer getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}
	public void setIsApproved(Integer isApproved) {
		this.isApproved = isApproved;
	}
	public Integer getIsApproved() {
		return isApproved;
	}
	
	
	
}
