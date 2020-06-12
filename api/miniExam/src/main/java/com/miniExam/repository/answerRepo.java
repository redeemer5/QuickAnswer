package com.miniExam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniExam.models.answerModel;


@Repository
public interface answerRepo extends JpaRepository<answerModel,Integer> {
	List<answerModel> findByqid (int qid);
	
}
