package com.ydel.shop.bank.bo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.ydel.bank.dao.BankDAO;
import com.ydel.bank.dao.impl.BankDAOImpl;
import com.ydel.bank.jpa.BankEntity;
import com.ydel.shop.jaxbeans.bank.BankConverter;
import com.ydel.shop.jaxbeans.bank.schemas.BankBean;
import com.ydel.shop.service.common.schemas.DrillDownBean;
import com.ydel.shop.service.core.exception.YdelAgroFaultBean;


public class BankBO {
	//private static URLLog logger = new URLL 
	
	BankDAO bankDAO = new BankDAOImpl();
	YdelAgroFaultBean faultBean = null;
	
	public BankBean createBank(EntityManager _emgr,BankBean bankBean)
	{
		BankBean bankBean1 = new BankBean();
		
		try {
			if(bankBean != null)
			{
				 BankEntity bankEntity = BankConverter.convetFromJaxBeans(_emgr, bankBean);
				 
				 BankEntity bankEntity2 = bankDAO.create(_emgr, bankEntity);
				 if(bankEntity2 == null)
				 {
					 faultBean = new YdelAgroFaultBean();
					 faultBean.setMessage("BankBean creation failed.");
					// logger.infoMessage("BankBO:createBank():BankBO Creation Failed");
					 faultBean.setSuccess(false);
					 bankBean.setFaultBean(faultBean);
				 }
				 else
				 {
					 bankBean1 = BankConverter.convertToJaxBeans(_emgr, bankEntity2, new ArrayList<DrillDownBean>());
					 faultBean = new YdelAgroFaultBean();
					 faultBean.setMessage("BankBO Created Successfully..");
				//	 logger.infoMessage("BankBO : createBank() :BankBO Created Successfully.");
					 faultBean.setSuccess(true);
					 bankBean1.setFaultBean(faultBean);
					 
				 }
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
			faultBean = new  YdelAgroFaultBean();
			faultBean.setMessage("Exception Occurred in createBank()");
		//	logger.infoMessage("BankBO : Exception Occurred in createBank() => " + e);
			faultBean.setSuccess(false);
			bankBean.setFaultBean(faultBean);
		}
		return bankBean1;
	}
	
	public List<BankBean> findAllBank(EntityManager _emgr)
	{
		List<BankBean> bankBeanList =  new ArrayList<BankBean>();
		try {
			List<BankEntity> bankEntityList = bankDAO.findAll(_emgr);
			for (BankEntity bankEntity : bankEntityList) {
				BankBean bankBean = BankConverter.convertToJaxBeans(_emgr, bankEntity, new ArrayList<DrillDownBean>());
				bankBeanList.add(bankBean);
			}
		} catch (Exception e) {
		
			throw new RuntimeException("BankBo: findAllBank(): Exception occured ->"+e);
		}
		return bankBeanList;
	}
	
	}
