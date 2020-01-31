package com.mindtree.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.dao.VehicleDao;
import com.mindtree.dao.jdbc.VehicleDaoJdbcImpl;
import com.mindtree.exception.ApplicationException;
import com.mindtree.exception.DaoException;

/**
 * Servlet implementation class VehicleServlet
 */
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException  {
		
		String uri=request.getRequestURI();		
		if(uri.endsWith("getRegNo.action"))
		{
			try {
				String category=request.getParameter("category");
				VehicleDao vehicleDao = new VehicleDaoJdbcImpl();	
				List<String> listReg=vehicleDao.getRegisterNumbers(category);
				PrintWriter out=response.getWriter();
				//System.out.println(listReg);
				out.print("<select name=\"regNoList\"><option value=\"-1\">--SELECT--</option>");
				for(String s: listReg)
				{
					out.print("<option value=\""+s+"\">"+s+"</option>");
				}
				out.print("</select>");
			} catch (DaoException e) {
				//e.printStackTrace();
				request.setAttribute("errMsg", e.getMessage());
			}
		}else if(uri.endsWith("totalRent.action"))
		{
			String bookedFrom=request.getParameter("bookedFrom");
			String bookedTo=request.getParameter("bookedTo");
			SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
			String regNo=request.getParameter("regNo");
			try {
				VehicleDao vehicleDao = new VehicleDaoJdbcImpl();
				try {
					Date bookedToDate = sdf.parse(bookedTo);
					Date bookedFromDate = sdf.parse(bookedFrom);
					long days=(bookedToDate.getTime() - bookedFromDate.getTime())/(1000L*60*60*24);
					double rent=vehicleDao.getRent(regNo);
					PrintWriter out=response.getWriter();
					out.print(days*rent);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			} catch (DaoException e) {
				//e.printStackTrace();
				request.setAttribute("errMsg", e.getMessage());
			}			
			
		}else if(uri.endsWith("bookVehicle.action"))
		{
			
		}
		
	}

}
