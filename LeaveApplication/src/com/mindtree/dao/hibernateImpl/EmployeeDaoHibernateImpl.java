package com.mindtree.dao.hibernateImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.entity.Employee;
import com.mindtree.vo.EmployeeLeaveVO;

public class EmployeeDaoHibernateImpl implements EmployeeDao {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return hibernateTemplate.find("from Employee as e where e.manager is not null");
	}

	@Override
	public List<Employee> getAllManagers() {

		return hibernateTemplate
				.find("from Employee as e where e.manager is null");
	}

	@Override
	public List<EmployeeLeaveVO> getEmployeesUnderManager(Integer managerId) {

		String get = "select l.leaveId,e.firstName,e.lastName,l.startDate,l.endDate from Leave as l join l.employee as e where e.manager.ssn=:managerId and l.isApproved=0";
		List<Object[]> objList = hibernateTemplate.findByNamedParam(get,
				"managerId", managerId);
		List<EmployeeLeaveVO> employeeLeaveVOs = new ArrayList<EmployeeLeaveVO>();
		for (int i = 0; i < objList.size(); i++) {
			Object[] obj = objList.get(i);
			EmployeeLeaveVO employeeLeaveVO = new EmployeeLeaveVO();
			employeeLeaveVO.setId((Integer) obj[0]);
			employeeLeaveVO.setName(obj[1] + " " + obj[2]);
			employeeLeaveVO.setStartDate((Date) obj[3]);
			employeeLeaveVO.setEndDate((Date) obj[4]);
			employeeLeaveVOs.add(employeeLeaveVO);
		}
		return employeeLeaveVOs;
	}

}
