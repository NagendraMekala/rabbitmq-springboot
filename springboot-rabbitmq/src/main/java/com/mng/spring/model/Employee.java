package com.mng.spring.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,
property="empId")
public class Employee {

	private String empName;
	private String empId;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}
    
	public void setEmpId(String empId) {
		this.empId = empId;
	}
           
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", getEmpName()=" + getEmpName() + ", getEmpId()="
				+ getEmpId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
