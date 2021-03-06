package com.cisco.cmad.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cisco.cmad.model.Event;
import com.cisco.cmad.model.Severity;
import com.cisco.cmad.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository repo;

	@Override
	public Page<Event> find(String source, Severity severity, LocalDateTime from, LocalDateTime to, PageRequest page) {
		return repo.findAll(getEventFindSpec(source, severity, from, to), page);
	}

	@Override
	public int count(String source, Severity severity, LocalDateTime from, LocalDateTime to) {
		return Math.toIntExact(repo.count(getEventFindSpec(source, severity, from, to)));
	}
	
	private Specification<Event> getEventFindSpec(String source, Severity severity, LocalDateTime from, LocalDateTime to) {
	      return new Specification<Event>() {
	          /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
	          public Predicate toPredicate(Root<Event> root,
	                                       CriteriaQuery<?> query,
	                                       CriteriaBuilder criteriaBuilder) {
	        	  List<Predicate> listPredicate = new ArrayList<Predicate>();
	        	  if(!StringUtils.isEmpty(source)) {
	        		  listPredicate.add(criteriaBuilder.equal(root.get("source"), source));
	        	  }
	        	  if(severity != null) {
	        		  listPredicate.add(criteriaBuilder.equal(root.get("severity"), severity));
	        	  }
	        	  if(to != null) {
	        		  listPredicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("timestamp"), Date.from( to.atZone( ZoneId.systemDefault()).toInstant())));
	        	  }
	        	  
	        	  Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("timestamp"), from!=null?Date.from(from.atZone( ZoneId.systemDefault()).toInstant()):Date.from(LocalDateTime.now().minusHours(6).atZone( ZoneId.systemDefault()).toInstant()));
	        	  for (Predicate eachPredicate : listPredicate) {
					predicate = criteriaBuilder.and(predicate, eachPredicate);
				  }
	        	  
	        	  return predicate;
	          }
	      };
	  }

}
