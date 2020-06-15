package com.miniExam.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.miniExam.models.answerModel;
import com.miniExam.models.questionModel;
import com.miniExam.models.topicModel;
import com.miniExam.models.userModel;
import com.miniExam.repository.answerRepo;
import com.miniExam.repository.questionRepo;
import com.miniExam.repository.topicRepo;
import com.miniExam.service.answerService;
import com.miniExam.service.questionService;
import com.miniExam.service.emailService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class controller {

	@Autowired
	public topicRepo topic;
	
	@Autowired
	public questionRepo qrepo;
	
	@Autowired
	public answerRepo arepo;
	
	@Autowired
	public answerService aService;
	
	@Autowired
	public questionService qService;
	
	@Autowired
	public emailService emailService;
	
	
	// gets all the topic
	@GetMapping("/getTopics")
	public List<topicModel> getTopics()
	{
		return topic.findAll();
	}
	
	// get topic to know where this question falls under
	@GetMapping("/getTopic/{tid}")
	public List<topicModel> getTopicById(@PathVariable int tid)
	{
		return topic.findBytid(tid);
	}
	
	// posting question
	@PostMapping("/postQuestion")
	public ResponseEntity<Object> postQuestion(@Valid @RequestBody questionModel question) 
	{
				questionModel questionModel = qrepo.save(question);
		
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{qid}")
						.buildAndExpand(questionModel.getQid()).toUri();
		
				return ResponseEntity.created(location).build();	
	}
	
	// gets all the questions under a specific topic
	@GetMapping("/getQuestion/{topic}")
	public List<questionModel> getQuestionByTopic(@PathVariable String topic)
	{
		return qrepo.findBytopic(topic);
	}
	
	
	// get question by id
	@GetMapping("/getQuestionById/{qid}")
	public List<questionModel> getQuestionById(@PathVariable int qid)
	{
		return qrepo.findByqid(qid);
	}
	
	
	// posting answer
		@PostMapping("/postAnswer")
		public ResponseEntity<Object> postAnswer(@Valid @RequestBody answerModel answer) 
		{
			answerModel answerModel = arepo.save(answer);
			
					URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{aid}")
							.buildAndExpand(answerModel.getAid()).toUri();
			
					return ResponseEntity.created(location).build();	
		}
		
	// finding the answer by qid
	@GetMapping("/getAnswerByqid/{qid}")
	public List<answerModel> getAnswerByQid(@PathVariable int qid)
	{
		return arepo.findByqid(qid);
	}
	
	// positively rate answer stored procedure
	@GetMapping("/rateAnswer/{aid}")
	public void rateAnswer(@PathVariable int aid)
	{
		aService.rateAnswer(aid);
	}
	
	// negatively rate answer stored procedure
		@GetMapping("/derateAnswer/{aid}")
		public void derateAnswer(@PathVariable int aid)
		{
			aService.derateAnswer(aid);
		}
		
		// delete question by id
		@GetMapping("/deleteQuestion/{qid}")
		public void deleteQuestion(@PathVariable int qid)
		{
			qService.deleteQuestion(qid);
		}
		
		// get all answers
		@GetMapping("/getAnswers")
		public List<answerModel> getAnswers()
		{
			return arepo.findAll();
		}
		
		// send email to student
		@GetMapping("/sendEmail/{email}/{message}")
		public void sendEmail(@PathVariable String email,@PathVariable String message)
		{
			emailService.sendEmail(email,message);	
		}
		
		// delete answer by id
				@GetMapping("/deleteAnswer/{aid}")
				public void deleteAnswer(@PathVariable int aid)
				{
					aService.deleteAnswer(aid);
				}
}
