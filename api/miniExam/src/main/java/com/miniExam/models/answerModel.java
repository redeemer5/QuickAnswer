package com.miniExam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answerTbl")
public class answerModel {
	
		// variables
		@Id
		@GeneratedValue
		public int aid;
		public String answer;
		public int qid;
		public int tid;
		public String email;
		public int Yesrate;
		public int Norate;
		public int studentNo;
		
		
		// getters n setters
		public int getAid() {
			return aid;
		}


		public void setAid(int aid) {
			this.aid = aid;
		}


		public String getAnswer() {
			return answer;
		}


		public void setAnswer(String answer) {
			this.answer = answer;
		}


		public int getQid() {
			return qid;
		}


		public void setQid(int qid) {
			this.qid = qid;
		}


		public int getTid() {
			return tid;
		}


		public void setTid(int tid) {
			this.tid = tid;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public int getYesrate() {
			return Yesrate;
		}


		public void setYesrate(int yesrate) {
			Yesrate = yesrate;
		}


		public int getNorate() {
			return Norate;
		}


		public void setNorate(int norate) {
			Norate = norate;
		}


		public int getStudentNo() {
			return studentNo;
		}


		public void setStudentNo(int studentNo) {
			this.studentNo = studentNo;
		}
		
		
		// constructor
		public answerModel(int aid, String answer, int qid, int tid, String email, int yesrate, int norate,
				int studentNo) {
			this.aid = aid;
			this.answer = answer;
			this.qid = qid;
			this.tid = tid;
			this.email = email;
			Yesrate = yesrate;
			Norate = norate;
			this.studentNo = studentNo;
		}
		
		
		// empty constructor
		public answerModel() {
			
		}

}
