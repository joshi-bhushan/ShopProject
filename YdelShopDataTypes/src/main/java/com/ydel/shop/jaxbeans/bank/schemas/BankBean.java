package com.ydel.shop.jaxbeans.bank.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.ydel.shop.service.core.exception.YdelAgroFaultBean;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="bankBean",propOrder={
		"bankId",
		"bankCode",
		"bankName",
		"bankAddress",
		"faultBean"
})

public class BankBean {
	
	@XmlElement(required=true,nillable=false)
	private Integer bankId;
	@XmlElement(required=true,nillable=false)
	private String bankAddress;
	@XmlElement(required=true,nillable=false)
	private String bankCode;
	@XmlElement(required=true,nillable=false)
	private String bankName;
	@XmlElement(name="faultBean",type=YdelAgroFaultBean.class,namespace="http://com/ydel/shop/service/core/exception")
	private YdelAgroFaultBean faultBean;
	public Integer getBankId() {
		return bankId;
	}
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public YdelAgroFaultBean getFaultBean() {
		return faultBean;
	}
	public void setFaultBean(YdelAgroFaultBean faultBean) {
		this.faultBean = faultBean;
	}
	
}