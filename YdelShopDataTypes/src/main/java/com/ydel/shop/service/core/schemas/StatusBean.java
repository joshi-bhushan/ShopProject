package com.ydel.shop.service.core.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="statusBean",propOrder={
		
		"success",
		"statusMessage",
		"numberOfRecordsProcessed",
		"numberOfRecordsFailed"
})
public class StatusBean {
	
	@XmlElement(required=true)
	protected boolean success;
	@XmlElement(required=true)
	private String statusMessage;
	@XmlElement(required=true)
	private Integer numberOfRecordsProcessed;
	@XmlElement(required=true)
	private Integer numberOfRecordsFailed;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Integer getNumberOfRecordsProcessed() {
		return numberOfRecordsProcessed;
	}
	public void setNumberOfRecordsProcessed(Integer numberOfRecordsProcessed) {
		this.numberOfRecordsProcessed = numberOfRecordsProcessed;
	}
	public Integer getNumberOfRecordsFailed() {
		return numberOfRecordsFailed;
	}
	public void setNumberOfRecordsFailed(Integer numberOfRecordsFailed) {
		this.numberOfRecordsFailed = numberOfRecordsFailed;
	}
	
	
	

}
