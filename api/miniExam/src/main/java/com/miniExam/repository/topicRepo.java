package com.miniExam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniExam.models.topicModel;



@Repository
public interface topicRepo extends JpaRepository<topicModel,Integer>{
	
	List<topicModel> findBytid(int tid);

}
