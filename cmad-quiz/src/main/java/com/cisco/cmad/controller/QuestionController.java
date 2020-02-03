package com.cisco.cmad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.cmad.model.Level;
import com.cisco.cmad.model.Question;
import com.cisco.cmad.repository.QuestionRepository;

@RestController(value = "/question")
@CrossOrigin
public class QuestionController {
	
	@Autowired
	private QuestionRepository repo;

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<Question> add(@RequestBody Question question) {
		question = repo.save(question);
		return new ResponseEntity<Question>(question, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Question>> find(@RequestParam(name = "subject", defaultValue = "") String subject, 
			@RequestParam(name = "level", defaultValue = "") Level level) {
		Page<Question> pageQuestions = repo.findBySubjectAndLevel(subject, level, PageRequest.of(1, 3));
		return new ResponseEntity<List<Question>>(pageQuestions.getContent(), HttpStatus.OK);
	}

}
