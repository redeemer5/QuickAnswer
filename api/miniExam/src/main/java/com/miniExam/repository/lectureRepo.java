package com.miniExam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniExam.models.lectureModel;


@Repository
public interface lectureRepo extends JpaRepository<lectureModel,Integer> {

}
