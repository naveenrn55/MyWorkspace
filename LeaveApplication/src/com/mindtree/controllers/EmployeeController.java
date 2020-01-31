/**
 * 
 */
package com.mindtree.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.dao.LeaveDao;
import com.mindtree.entity.Employee;
import com.mindtree.entity.Leave;
import com.mindtree.vo.EmployeeLeaveVO;

/**
 * 
 *
 */

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private LeaveDao leaveDao;
	
	@ModelAttribute("managerList")
	public List<Employee> populateManager()
	{
		return employeeDao.getAllManagers();
	}
	
	
	@RequestMapping("/approveLeave.action")
	public String approveLeave(Model model )
	{
		return "approveLeave";
	}
	
	@RequestMapping("/getAllLeaves.action")
	public String getApprovals(@RequestParam("manager") Integer managerId,Model model)
	{
		Map<Integer, String> empMap=new HashMap<Integer, String>();
		List<EmployeeLeaveVO> employeeLeaveVOs=employeeDao.getEmployeesUnderManager(managerId);
		for(EmployeeLeaveVO e:employeeLeaveVOs)
		{
			empMap.put(e.getId(), e.getName()+" (Start Date "+e.getStartDate()+" End date "+e.getEndDate()+")");
		}
		model.addAttribute("employeeMap", empMap);
		return "approveEmployeeLeave";
		
	}
	
	@RequestMapping("/approveLeaveForEmployee.action")
	public String approveLeaveForEmployee(HttpServletRequest request,Model model)
	{
		String[] ids=request.getParameterValues("leaveId");
		for(String s:ids)
		{
			Integer id=Integer.parseInt(s);
			leaveDao.approveLeave(id);
		}
		model.addAttribute("message", "Successfully approved");
		return "index";
	}
}
