package com.cisco.cmad.dto;

public class Metadata extends Count{

	public Metadata(int count) {
		super(count);
	}

	String prev;
	String next;
	
	public String getPrev() {
		return prev;
	}
	public void setPrev(String prev) {
		this.prev = prev;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "Metadata [prev=" + prev + ", next=" + next + "]";
	}
	
	
}
