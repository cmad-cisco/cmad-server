package com.cisco.cmad.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table
public class Event implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column
    private long id;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timestamp;
    
    @NotEmpty(message = "Event source must not be empty")
    @Column
	private String source;
    
    @NotEmpty(message = "Log handler must not be empty")
    @Column
	private String logHandler;
    
    @NotNull(message = "Log severity must not be empty")
    @Enumerated(EnumType.ORDINAL)
    @Column
	private Severity severity;
    
    @NotNull
    @Column(length = 10000)
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long reservationId) {
		this.id = reservationId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLogHandler() {
		return logHandler;
	}

	public void setLogHandler(String logHandler) {
		this.logHandler = logHandler;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logHandler == null) ? 0 : logHandler.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((severity == null) ? 0 : severity.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (logHandler == null) {
			if (other.logHandler != null)
				return false;
		} else if (!logHandler.equals(other.logHandler))
			return false;
		if (id != other.id)
			return false;
		if (severity != other.severity)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", timestamp=" + timestamp + ", source=" + source
				+ ", logHandler=" + logHandler + ", severity=" + severity + ", message=" + message + "]";
	}
    

	
}
