package com.miniExam.service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

@Service
public class questionService {
	
	 @PersistenceContext
	  private EntityManager entityManager;
	 
	 // delete question by calling stored procedure in the sql database
	 public void deleteQuestion(int qid)
	 {
	        //"login" this is the name of your procedure
	        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteQuestion"); 

	        //Declare the parameters in the same order
	        query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);


	        //Pass the parameter values
	        query.setParameter(1, qid);


	        //Execute query
	        query.execute();

	 
	 }

}
