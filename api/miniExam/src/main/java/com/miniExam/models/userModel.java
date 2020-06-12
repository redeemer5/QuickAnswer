package com.miniExam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userTbl")
public class userModel {
	
	// variables
	
	@Id
	@GeneratedValue
	public int uid;
	public int studentNo;
	public String name;
	public String email;
	public String cellNumber;
	public String moduleName;
	public String password;
	
	
	// getters and setters
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// constructor 
	public userModel(int uid, int studentNo, String name, String email, String cellNumber, String moduleName,
			String password) {
		this.uid = uid;
		this.studentNo = studentNo;
		this.name = name;
		this.email = email;
		this.cellNumber = cellNumber;
		this.moduleName = moduleName;
		this.password = password;
	}
	
	
	// empty constructor
	
	public userModel() {
	
	}
	
	
	

}
