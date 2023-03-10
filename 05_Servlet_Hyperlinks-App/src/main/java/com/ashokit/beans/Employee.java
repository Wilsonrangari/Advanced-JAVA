package com.ashokit.beans;

public class Employee {
	
	private Integer employeeId;
	private String employeeName;
	private String city;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeNameString(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
		
	}
	public Employee(Integer employeeId, String employeeName, String city) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", city=" + city+ "]";
	}

}
	
