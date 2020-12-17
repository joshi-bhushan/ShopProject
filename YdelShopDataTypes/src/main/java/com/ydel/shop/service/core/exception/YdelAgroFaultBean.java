package com.ydel.shop.service.core.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ydelAgroFaultBean",propOrder={
		"",
		""
})
public class YdelAgroFaultBean {
	@XmlElement(required=true)
	protected boolean success;
	@XmlElement
	protected String message;
	
	public YdelAgroFaultBean() {
		
			}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setMessage(Throwable t)
	{
		setMessage(ExceptionUtils.getMessage(t));
	}
	


		

	
}
