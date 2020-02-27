package com.cisco.cmad.dto;

import java.util.List;

import com.cisco.cmad.model.Event;

public class PaginatedEventResult {
	
	List<Event> data;
	Metadata metadata;
	
	public List<Event> getData() {
		return data;
	}
	public void setData(List<Event> data) {
		this.data = data;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	@Override
	public String toString() {
		return "PaginatedEventResult [data=" + data + ", metadata=" + metadata + "]";
	}
	
	

}
