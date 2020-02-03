package com.cisco.cmad.dto;

public class Answer {

	private long qid;
	private String option;

	public long getQid() {
		return qid;
	}

	public void setQid(long qid) {
		this.qid = qid;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "Answer [qid=" + qid + ", option=" + option + "]";
	}
}
