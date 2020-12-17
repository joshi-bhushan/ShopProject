package com.ydel.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.ydel.bank.jpa.BankEntity;

public interface BankDAO {
	public BankEntity create(EntityManager entityManager,BankEntity bankEntity);
	public List<BankEntity> findAll(EntityManager entityManager);
	public BankEntity findByCode(EntityManager entityManager,String bankCode);

}
