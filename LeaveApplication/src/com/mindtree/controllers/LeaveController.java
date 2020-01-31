/**
 * 
 */
package com.mindtree.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mindtree.dao.EmployeeDao;
import com.mindtree.dao.LeaveDao;
import com.mindtree.dao.LeaveTypeDao;
import com.mindtree.entity.Employee;
import com.mindtree.entity.Leave;
import com.mindtree.entity.LeaveType;

/**
 * 
 * 
 */

@Controller
public class LeaveController {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private LeaveTypeDao leaveTypeDao;

	@Autowired
	private LeaveDao leaveDao;

	@ModelAttribute("leaveTypeList")
	public List<LeaveType> populateLeaveType() {
		return leaveTypeDao.getAllLeaveTypes();
	}

	@ModelAttribute("employeeMap")
	public Map<Integer, String> populateEmployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		Map<Integer, String> empMap = new HashMap<Integer, String>();
		for (Employee e : employees) {
			empMap.put(e.getSsn(), e.getFirstName() + " " + e.getLastName());
		}
		return empMap;
	}

	@RequestMapping("/applyLeave.action")
	public String applyLeave(Model model) {
		model.addAttribute("leave", new Leave());
		return "applyLeave";
	}

	@RequestMapping("/addLeave.action")
	public String addLeave(@ModelAttribute("leave") Leave leave,
			BindingResult errors, Model model) {

		leave.setIsApproved(0);
		leaveDao.applyLeave(leave);
		model.addAttribute("message", "Leave is applied successfully");
		return "index";

	}
	
	@RequestMapping("/getNoOfDays.action")
	public String noOfDays(@ModelAttribute("leave") Leave leave)
	{
		Date stDate=leave.getStartDate();
		Date edDate=leave.getEndDate();
		int d=stDate.compareTo(edDate);
		leave.setNoOfDays(d);
		return "applyLeave";
	}
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
