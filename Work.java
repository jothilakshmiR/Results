package com.program.Employee;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;





@Entity
@Table(name ="Work") 
public class Work {
	@ManyToOne

	
	
	 private int WId;
	  private   WorkName WName;
	  @Column(name="WName")
	  private String department;
	  @Column(name="Work_department")
	
	   private int salary;
	  @Column(name="JOINED_ON")
	   private Date joinedOn;
	public int getEmpId() {
		return WId;
	}
	public void setEmpId(int empId) {
		this.WId = empId;
	}
	
	public WorkName getWName() {
		return WName;
	}
	public void setWName(WorkName wn) {
		WName =  WName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getJoinedOn() {
		return joinedOn;
	}
	public void setJoinedOn(Date joinedOn) {
		this.joinedOn = joinedOn;
	}
	@Override
	public String toString() {
		return "Work [WId=" + WId + ", WName=" + WName + ", department=" + department + ", salary=" + salary
				+ ", joinedOn=" + joinedOn + "]";
	}
	
	   
}


