package com.miniExam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.miniExam.models.userModel;


@Service
public class emailService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired 
	public emailService(JavaMailSender javaMailSender)
	{
		this.javaMailSender = javaMailSender;
	}

	public void sendEmail(String email,String message) throws MailException
	{
		// send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setFrom("w12rline6@gmail.com");
		mail.setSubject("UJ");
		mail.setText(message);
	
		javaMailSender.send(mail);
	}
}
