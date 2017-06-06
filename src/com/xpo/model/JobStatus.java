package com.xpo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job_status")
public class JobStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private JobStatusPK jobStatusPK;
	
	
	@Column(name = "Status")
	private String status;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobStatusPK getJobStatusPK() {
		return jobStatusPK;
	}

	public void setJobStatusPK(JobStatusPK jobStatusPK) {
		this.jobStatusPK = jobStatusPK;
	}
	
	

}
