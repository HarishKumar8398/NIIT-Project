package com.niit.Mainproject.model1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name= "EMPLOYEES_DETAILS ")
@Entity
public class Employee {
	@Id
	@GeneratedValue
	
	@Column(name="EMP_ID", nullable=false)
	int empId;
	
	@Column(name="EMP_NAME", nullable=false)
	String name;
	
	@Column(name="EMP_DESIGNATION", nullable=false)
	String designation;
	
	@Column(name="EMP_SALARY", nullable=false)
	int salary;

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
    public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}

