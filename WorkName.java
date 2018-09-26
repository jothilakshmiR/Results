package com.program.Employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="EMPLOYEE")
public class WorkName {
	@Id
	 @Column(name="firstname")
	private String Fname;
	 @Column(name="Lastname")
	private String Lname;
	 @Column(name="Middlename")
	private String Mname;
	private int salary;
	private Date joinedOn;
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getMname() {
		return Mname;
	}
	public void setMname(String mname) {
		Mname = mname;
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
		return "WorkName [Fname=" + Fname + ", Lname=" + Lname + ", Mname=" + Mname + ", salary=" + salary
				+ ", joinedOn=" + joinedOn + "]";
	}
	
}