package com.ydel.shop.response.bank.schemas;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.ydel.shop.jaxbeans.bank.schemas.BankBean;
import com.ydel.shop.service.core.schemas.EntityBean;
import com.ydel.shop.service.core.schemas.StatusBean;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="bankResponseBean",propOrder={
		
		"bankBeanList",
		"bankBeanFind",
		"entityBean",
		"statusBean"
})
public class BankResponseBean {
	@XmlElement
	private List<BankBean> bankBeanList;
	@XmlElement
	private BankBean bankBeanFind;
	@XmlElement(name="entity",type=EntityBean.class,namespace="http://com/ydel/shop/service/core/schemas")
	private EntityBean entityBean;
	@XmlElement
	private StatusBean statusBean;
	public List<BankBean> getBankBeanList() {
		return bankBeanList;
	}
	public void setBankBeanList(List<BankBean> bankBeanList) {
		this.bankBeanList = bankBeanList;
	}
	public BankBean getBankBeanFind() {
		return bankBeanFind;
	}
	public void setBankBeanFind(BankBean bankBeanFind) {
		this.bankBeanFind = bankBeanFind;
	}
	public EntityBean getEntityBean() {
		return entityBean;
	}
	public void setEntityBean(EntityBean entityBean) {
		this.entityBean = entityBean;
	}
	public StatusBean getStatusBean() {
		return statusBean;
	}
	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}
	
	
	
	

}
