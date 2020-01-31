/**
 * 
 */
package com.mindtree.dao.hibernateImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mindtree.dao.LeaveTypeDao;
import com.mindtree.entity.LeaveType;

/**
 * 
 *
 */
public class LeaveTypeDaoHibernateImpl implements LeaveTypeDao {

	/* (non-Javadoc)
	 * @see com.mindtree.dao.LeaveTypeDao#getAllLeaveTypes()
	 */
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		hibernateTemplate=new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public List<LeaveType> getAllLeaveTypes() {
		
		return hibernateTemplate.find("from LeaveType");
	}

}
