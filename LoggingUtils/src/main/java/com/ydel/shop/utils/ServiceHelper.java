package com.ydel.shop.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

public class ServiceHelper {
	
	transient private EntityManager entityMgr = null;

	private boolean isLocal = false;

	public ServiceHelper() {
	}

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	public ServiceHelper(EntityManager entityMgr) {
		this.entityMgr = entityMgr;
	}

	public EntityManager getEntityMgr(String name) throws NamingException {
		if (this.entityMgr == null) {
			this.entityMgr = JPAUtil.getEntityManager(name);
		}
		return this.entityMgr;
	}
	public EntityManager  getEntityMgr1()
	{
		if(this.entityMgr == null)
		{
			this.entityMgr = JPAUtil.getEntityManager1();
		}
		return  this.entityMgr;
	}

	public boolean beginTransaction(String name) throws Exception {

		if(name == null || name.trim() == ""){
			name = "admin";
		}
		
		if (entityMgr == null) {
			entityMgr = getEntityMgr(name);
		}
		
		UserTransaction txnMgr = (UserTransaction) new InitialContext()
				.lookup("java:comp/UserTransaction");

		if (txnMgr.getStatus() == Status.STATUS_NO_TRANSACTION) {
			txnMgr.begin();
			if (!isLocal) {
				entityMgr.joinTransaction();
			}

			/*logger.debugMessage("ServiceHelper.beginTransaction : TransactionManager :=> "
					+ txnMgr + " And EntityManager :=> " + entityMgr);
			logger.debugMessage("ServiceHelper.beginTransaction : txnMgr txn : ==> "
					+ txnMgr.getStatus());*/
			return true;
		}

		return false;
	}
		public void rollbackTransaction() {
		UserTransaction txnMgr = null;
		try {
			txnMgr = (UserTransaction) new InitialContext()
					.lookup("java:comp/UserTransaction");
			if (txnMgr != null) {
				//logger.debugMessage("ServiceHelper.rollbackTransaction : TransactionManager :=> " + txnMgr + " And EntityManager :=> " + entityMgr);
				try {
					txnMgr.rollback();
				} catch (Throwable e) {
					//logger.debugMessage("ServiceHelper.rollbackTransaction : TransactionManager :=> "+ txnMgr + " And Error :=> " + e);
				}
				txnMgr = null;
			}
		} catch (NamingException e2) {
			//logger.debugMessage("ServiceHelper.rollbackTransaction : TransactionManager :=> "+ txnMgr + " And Error :=> " + e2);
		}

	}

	public void commitTransaction() throws Exception {
		UserTransaction txnMgr = null;
		try {
			txnMgr = (UserTransaction) new InitialContext()
					.lookup("java:comp/UserTransaction");
			if (txnMgr != null) {
				txnMgr.commit();
				//logger.debugMessage("ServiceHelper.commitTransaction : TransactionManager :=> "+ txnMgr + " And EntityManager :=> " + entityMgr);
				//logger.debugMessage("ServiceHelper.commitTransaction : txnMgr txn : ==> "+ txnMgr.getStatus());
				txnMgr = null;
			}
		} catch (NamingException e) {
			//logger.debugMessage("ServiceHelper.commitTransaction : TransactionManager :=> "+ txnMgr + " And Error :=> " + e);
		}

	}

	public boolean beginTransaction1() throws Exception{
		
		
		if(entityMgr == null)
		{
			entityMgr = getEntityMgr1();
			UserTransaction txnMgr = (UserTransaction) new InitialContext()
					.lookup("java:comp/UserTransaction");

			if (txnMgr.getStatus() == Status.STATUS_NO_TRANSACTION) {
				txnMgr.begin();
				if (!isLocal) {
					entityMgr.joinTransaction();
				}

				/*logger.debugMessage("ServiceHelper.beginTransaction : TransactionManager :=> "
						+ txnMgr + " And EntityManager :=> " + entityMgr);
				logger.debugMessage("ServiceHelper.beginTransaction : txnMgr txn : ==> "
						+ txnMgr.getStatus());*/
				return true;
			}
		}

			return false;

			
		
	}

	
}
