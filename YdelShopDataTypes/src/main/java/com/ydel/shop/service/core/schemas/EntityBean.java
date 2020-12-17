package com.ydel.shop.service.core.schemas;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.ydel.shop.jaxbeans.bank.schemas.BankBean;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="entityBean",propOrder={
		"bankBeanList",
		"bankBean"
})
public class EntityBean {
	//com.ydel.shop.jaxbeans.bank.schemas
	@XmlElement(name="entity",type=BankBean.class,namespace="http://ydel/shop/jaxbeans/bank/schemas")
	private List<BankBean> bankBeanList;
	
	//com.ydel.shop.jaxbeans.bank.schemas
	@XmlElement(name="entity1",type=BankBean.class,namespace="http://ydel/shop/jaxbeans/bank/schemas")
	private BankBean bankBean;

	public List<BankBean> getBankBeanList() {
		return bankBeanList;
	}

	public void setBankBeanList(List<BankBean> bankBeanList) {
		this.bankBeanList = bankBeanList;
	}

	public BankBean getBankBean() {
		return bankBean;
	}

	public void setBankBean(BankBean bankBean) {
		this.bankBean = bankBean;
	}
	

}
