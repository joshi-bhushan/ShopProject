package com.ydel.shop.jaxbeans.bank;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import com.ydel.bank.jpa.BankEntity;
import com.ydel.shop.jaxbeans.bank.schemas.BankBean;
import com.ydel.shop.service.common.schemas.DrillDownBean;

public class BankConverter {
	
	public static BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();
	static{
		beanUtils.getConvertUtils().register(false, true, 0);
		
		
	}
	public static BankEntity convetFromJaxBeans(EntityManager _emgr,BankBean bankBean) throws IllegalAccessException,InvocationTargetException
	{
		BankEntity bankEntity = new BankEntity();
		if(bankBean != null)
		{
			beanUtils.copyProperties(bankEntity, bankBean);
		}
		return bankEntity;
	}
	public static BankBean convertToJaxBeans(EntityManager _emgr,BankEntity bankEntity,List<DrillDownBean> childParams)throws IllegalAccessException , InvocationTargetException
	{
		
		BankBean bankBean  = new BankBean();
		if(bankEntity != null)
		{
			beanUtils.copyProperties(bankBean, bankEntity);
		}
		return bankBean;
	}
}
