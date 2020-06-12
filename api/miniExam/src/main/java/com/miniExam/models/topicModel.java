package com.miniExam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "topicTbl")
public class topicModel {
	
	
	// variables
	
	@Id
	@GeneratedValue
	public int tid;
	public String topic;
	
	// getters n setters
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	// constructor 
	public topicModel(int tid, String topic) {
		this.tid = tid;
		this.topic = topic;
	}
	
	
	// empty constructor 
	
	public topicModel() {
		
	}
	

}
