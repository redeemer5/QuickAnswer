package com.miniExam.service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

@Service
public class answerService {

	 @PersistenceContext
	  private EntityManager entityManager;
	 
	 
	 // rate answer positively by calling stored procedure in the sql database
	 public void rateAnswer(int Yesrate)
	 {
	        //"login" this is the name of your procedure
	        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("rateAnswer"); 

	        //Declare the parameters in the same order
	        query.registerStoredProcedureParameter(8, Integer.class, ParameterMode.IN);


	        //Pass the parameter values
	        query.setParameter(8, Yesrate);


	        //Execute query
	        query.execute();

	 
	 }
	 
	 
	// rate answer negatively by calling stored procedure in the sql database
	 public void derateAnswer(int Norate)
	 {
	        //"login" this is the name of your procedure
	        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("derateAnswer"); 

	        //Declare the parameters in the same order
	        query.registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN);


	        //Pass the parameter values
	        query.setParameter(4, Norate);


	        //Execute query
	        query.execute();
	 }
	 
	 // delete question by calling stored procedure in the sql database
	 public void deleteAnswer(int aid)
	 {
	        //"login" this is the name of your procedure
	        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deleteAnswer"); 

	        //Declare the parameters in the same order
	        query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);

	        //Pass the parameter values
	        query.setParameter(1, aid);

	        //Execute query
	        query.execute();

	 }
}
