package com.miniExam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniExam.models.questionModel;


@Repository
public interface questionRepo extends JpaRepository<questionModel,Integer> {

	List<questionModel> findBytopic(String topic);
	
	List<questionModel> findByqid(int qid);
}
