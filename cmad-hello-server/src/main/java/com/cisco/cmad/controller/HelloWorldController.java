package com.cisco.cmad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.cmad.model.Message;
import com.cisco.cmad.repository.MessageRepository;

@RestController
@CrossOrigin
public class HelloWorldController {
	
	@Autowired
	private MessageRepository m_messageRepo;
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public ResponseEntity<Message> hello(){
		Message message = m_messageRepo.findAll().get(0);
		if(message == null) {
			return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Message>(message, HttpStatus.OK);
				
	}

}
