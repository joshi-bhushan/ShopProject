package com.ydel.shop.service.core.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.ydel.shop.response.bank.schemas.BankResponseBean;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="responseData",propOrder={
		
		"bankResponseBeanFind"
})
public class ResponseData {
	
	//com.ydel.shop.response.bank.schemas
	
	@XmlElement(name="responseBean",type=BankResponseBean.class,namespace="http://ydel/shop/response/bank/schemas")
	private BankResponseBean bankResponseBeanFind;

	public BankResponseBean getBankResponseBeanFind() {
		return bankResponseBeanFind;
	}

	public void setBankResponseBeanFind(BankResponseBean bankResponseBeanFind) {
		this.bankResponseBeanFind = bankResponseBeanFind;
	}
	

}
