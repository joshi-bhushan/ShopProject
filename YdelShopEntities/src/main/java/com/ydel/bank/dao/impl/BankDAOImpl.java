package com.ydel.bank.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ydel.bank.dao.BankDAO;
import com.ydel.bank.jpa.BankEntity;

public class BankDAOImpl implements BankDAO {

	public BankEntity create(EntityManager entityManager, BankEntity bankEntity) {
		
		BankEntity bankEntity2 =null;
		try {
			bankEntity2 =entityManager.merge(bankEntity);
		} catch (Exception e) {
			throw new RuntimeException("BankDAOImpl:create():exceptioon occured->"+e);
		}
		return bankEntity2;
	}

	public List<BankEntity> findAll(EntityManager entityManager) {
		List<BankEntity> bankEntityList = new ArrayList<BankEntity>();
		try {
			bankEntityList = entityManager.createNamedQuery("BankEntity.findAll",BankEntity.class)
					.setHint(org.eclipse.persistence.config.QueryHints.REFRESH, org.eclipse.persistence.config.HintValues.TRUE)
					.getResultList();
		} catch (Exception e) {
			throw new RuntimeException("BankDAOImpl:findAll():exceptioon occured->"+e);
		}
		return bankEntityList;
	}

	public BankEntity findByCode(EntityManager entityManager, String bankCode) {
		BankEntity bankEntity =null;
		try {
			bankEntity = entityManager.createNamedQuery("BankEntity.findBYCode",BankEntity.class)
					.setHint(org.eclipse.persistence.config.QueryHints.REFRESH,org.eclipse.persistence.config.HintValues.TRUE)
					.getSingleResult();	
			
		} catch (Exception e) {
			throw new RuntimeException("BankDAOImpl:findByCode():exceptioon occured->"+e);
		}
		return bankEntity;
	}

}
