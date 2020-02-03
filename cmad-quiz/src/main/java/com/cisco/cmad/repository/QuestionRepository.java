package com.cisco.cmad.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.cmad.model.Level;
import com.cisco.cmad.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
	public Page<Question> findBySubjectAndLevel(String subject, Level level, Pageable page);
	public Long countByIdAndAnswer(long qid, String answer);
}
