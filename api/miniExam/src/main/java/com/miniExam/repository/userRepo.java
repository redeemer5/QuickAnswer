package com.miniExam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniExam.models.userModel;


@Repository
public interface userRepo extends JpaRepository<userModel,Integer> {
	
	List<userModel> findByEmailAndPassword(String email,String Password);

}
