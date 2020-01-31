/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mindtree.dao.LeaveDao;
import com.mindtree.entity.Leave;

/**
 * 
 *
 */
public class LeaveDaoHibernateImpl implements LeaveDao {

	/* (non-Javadoc)
	 * @see com.mindtree.dao.LeaveDao#applyLeave(com.mindtree.entity.Leave)
	 */
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		hibernateTemplate=new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public void applyLeave(Leave leave) {
		
		hibernateTemplate.save(leave);

	}

	@Override
	public void approveLeave(Integer leaveId) {
		
		Leave leave=hibernateTemplate.get(Leave.class, leaveId);
		leave.setIsApproved(1);
		hibernateTemplate.save(leave);
		
	}

	

}
