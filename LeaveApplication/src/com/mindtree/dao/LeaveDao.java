/**
 * 
 */
package com.mindtree.dao;

import com.mindtree.entity.Leave;

/**
 * 
 *
 */
public interface LeaveDao {

	public void applyLeave(Leave leave);
	public void approveLeave(Integer leaveId);
}
