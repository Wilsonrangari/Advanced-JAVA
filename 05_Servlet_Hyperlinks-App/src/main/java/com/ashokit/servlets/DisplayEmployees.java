package com.ashokit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashokit.beans.Employee;

public class DisplayEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//setting the content type
		response.setContentType("text/html");
		
		//getting the writer object
		PrintWriter pw = response.getWriter();
		
		//collecting the request parameter from index.Html file using city
		String cityName = request.getParameter("city");
		
		//getting all employees
		List<Employee> allEmployees = getAllEmployees();
		
		if(cityName!=null) {
			//1.converting the list into stream object
			//2.Apply filter condition based on business requirement based on city
			//3.Collecting the results into collection List object
			allEmployees=getAllEmployees().stream()
										  .filter(e->cityName.equals(e.getCity()))
										  .collect(Collectors.toList());
		}
		
		pw.println("<body bgcolor='#3cb371'>");
		pw.println("<h4 style='text-align: center; color: yellow;'>Welcome To AshokIT Hyperlink Using Servlet Programming.....</h4>");
		pw.println("<table align='center' border='2'>");
		pw.println("<tr><th>Employee Id</th><th>Employee Name</th><th>City</th></tr>");
		
		//using java 8 for looping the employees 
		allEmployees.forEach((emp) ->{
			pw.println("<tr><td>"+emp.getEmployeeId()+"</td><td>"+emp.getEmployeeName()+"</td><td>"+emp.getCity()+"</td></tr>");
		});
		pw.println("</table>");
		pw.println("</body>");
		pw.println("<div style='text-align:center'><a href='index.html'>|Home Page|</a></div>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private List<Employee> getAllEmployees(){
		return Arrays.asList(new Employee(01,"Mahesh","Hydrabad"),
							 new Employee(02, "Ashok", "Pune"),
							 new Employee(03, "Wilson", "Hof"),
							 new Employee(04, "Sarath", "Pune"),
							 new Employee(05, "Vinay", "Delhi"));
		
	}

}
