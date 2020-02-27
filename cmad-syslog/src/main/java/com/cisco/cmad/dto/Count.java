package com.cisco.cmad.dto;

public class Count {
	int count;

	public Count(int count) {
		super();
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "Count [count=" + count + "]";
	}
	

}
