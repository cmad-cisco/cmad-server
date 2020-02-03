package com.cisco.cmad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.cmad.dto.Answer;
import com.cisco.cmad.repository.QuestionRepository;

@RestController(value = "/answer")
@CrossOrigin
public class AnswerController {
	
	@Autowired
	private QuestionRepository repo;

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<Long> search(@RequestBody List<Answer> answers) {
		Long count = 0L;
		for (Answer answer : answers) {
			count += repo.countByIdAndAnswer(answer.getQid(), answer.getOption());
		}
		return new ResponseEntity<Long>(count, HttpStatus.OK);
	}
}
