package com.miniExam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lectureTbl")
public class lectureModel {
	
	// variables
	
	@Id
	@GeneratedValue
	public int lid;
	public int lectureNo;
	public String password;
	
	// getters n setters 
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getLectureNo() {
		return lectureNo;
	}
	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	// constructor
	public lectureModel(int lid, int lectureNo, String password) {
		this.lid = lid;
		this.lectureNo = lectureNo;
		this.password = password;
	}
	
	
	// empty constructor
		public lectureModel() {
			
		}
	

}
