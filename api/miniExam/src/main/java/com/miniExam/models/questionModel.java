package com.miniExam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionTbl")
public class questionModel {
	
	// variables
	
	@Id
	@GeneratedValue
	public int qid;
	public String question;
	public String topic;
	
	// getters and setter
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	// constructor 
	public questionModel(int qid, String question, String topic) {
		this.qid = qid;
		this.question = question;
		this.topic = topic;
	}
	
	// empty constructor 
	public questionModel() {
		
	}
	
	

}
