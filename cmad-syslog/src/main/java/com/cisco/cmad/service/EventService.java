package com.cisco.cmad.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.cisco.cmad.model.Event;
import com.cisco.cmad.model.Severity;

public interface EventService {
	
	public Page<Event> find(String source, Severity severity, LocalDateTime from, LocalDateTime to, PageRequest page);
	
	public int count(String source, Severity severity, LocalDateTime from, LocalDateTime to);
	
	

}
