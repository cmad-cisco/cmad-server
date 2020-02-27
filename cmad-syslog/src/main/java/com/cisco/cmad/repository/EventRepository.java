package com.cisco.cmad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cisco.cmad.model.Event;

@Repository
public interface EventRepository extends JpaSpecificationExecutor<Event>,JpaRepository<Event, String> {
	
}
