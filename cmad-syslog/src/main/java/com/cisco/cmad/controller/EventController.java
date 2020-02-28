package com.cisco.cmad.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.cmad.dto.Count;
import com.cisco.cmad.dto.Metadata;
import com.cisco.cmad.dto.PaginatedEventResult;
import com.cisco.cmad.dto.SeveritySummaryStat;
import com.cisco.cmad.model.Event;
import com.cisco.cmad.model.Severity;
import com.cisco.cmad.repository.EventRepository;
import com.cisco.cmad.service.EventService;

@RestController
@CrossOrigin
@Validated
@RequestMapping(path = "/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private EventRepository eventRepo;

	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Event> save(@RequestBody Event event) {
		event = eventRepo.save(event);
		return new ResponseEntity<Event>(event, HttpStatus.CREATED);
	}

	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<PaginatedEventResult> find(@RequestParam(name = "source", defaultValue = "") String source, 
			@RequestParam(name = "severity", defaultValue = "") Severity severity,
			@RequestParam(name = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
			@RequestParam(name = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to,
			@RequestParam(name = "page", defaultValue = "1") @Min(1) Integer page,
			@RequestParam(name = "size", defaultValue = "10") @Min(1) Integer size,
			HttpServletRequest httpRequest) {
		Page<Event> pageEvents = eventService.find(source, severity, from, to, PageRequest.of(page-1, size, Sort.by("timestamp").descending()));
		int count = eventService.count(source, severity, from, to);
		PaginatedEventResult result = new PaginatedEventResult();
		result.setData(pageEvents.getContent());
		result.setMetadata(new Metadata(count));
		return new ResponseEntity<PaginatedEventResult>(result, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/count", method = RequestMethod.GET)
	public ResponseEntity<Count> count(@RequestParam(name = "source", defaultValue = "") String source, 
			@RequestParam(name = "severity", defaultValue = "") Severity severity,
			@RequestParam(name = "from", defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
			@RequestParam(name = "to", defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
		return new ResponseEntity<Count>(new Count(eventService.count(source, severity, from, to)), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/summarystat", method = RequestMethod.GET)
	public ResponseEntity<SeveritySummaryStat> count(@RequestParam(name = "source", defaultValue = "") String source,
			@RequestParam(name = "from", defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
			@RequestParam(name = "to", defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
		SeveritySummaryStat result = new SeveritySummaryStat();
		for (Severity severity : Severity.values()) {
			switch (severity) {
			case alert:
				result.setAlert(new Count(eventService.count(source, severity, from, to)));
				break;
			case crit:
				result.setCrit(new Count(eventService.count(source, severity, from, to)));
				break;
			case debug:
				result.setDebug(new Count(eventService.count(source, severity, from, to)));
				break;
			case emerg:
				result.setEmerg(new Count(eventService.count(source, severity, from, to)));
				break;
			case err:
				result.setErr(new Count(eventService.count(source, severity, from, to)));
				break;
			case info:
				result.setInfo(new Count(eventService.count(source, severity, from, to)));
				break;
			case notice:
				result.setNotice(new Count(eventService.count(source, severity, from, to)));
				break;
			case warn:
				result.setWarn(new Count(eventService.count(source, severity, from, to)));
				break;
			
			}
		}
		
		return new ResponseEntity<SeveritySummaryStat>(result, HttpStatus.OK);
	}

}
