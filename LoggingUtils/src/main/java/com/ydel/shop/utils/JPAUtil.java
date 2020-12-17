package com.ydel.shop.utils;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JPAUtil {
	
	private static EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();
	

	static HashMap<String, EntityManager> entityHashMap = null;
	static EntityManager manager = null;
	
	
	static{
		try {
			System.out.println("entered");
			manager = emf.createEntityManager();
			entityHashMap = new HashMap<String, EntityManager>();
			manager.setProperty("eclipselink.tenat-id","shop_common" );
			entityHashMap.put("shop_common", manager);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static EntityManager getEntityManager1(){
		EntityManager entityManager;
		try {
			entityManager = threadEntityManager.get();
			
			if(entityManager == null || !(entityManager.isOpen()))
			{
				
				entityManager = emf.createEntityManager();
				threadEntityManager.set(entityManager);
			}
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
		return entityManager;
	}
	
	
	public static void closeEntityManager1()
	{
		EntityManager em = threadEntityManager.get();
		threadEntityManager.set(null);
		
		if(em != null)
		{
			em.close();
		}
	}
	
	public static EntityManager getEntityManager(String name)
	{
		EntityManager entityManager;
		
		try{
			
			entityManager = entityHashMap.get(name);
			
			if(entityManager == null)
			{
				entityManager = emf.createEntityManager();
				entityManager.setProperty("eclipselink.tenat", name);
				entityHashMap.put(name, entityManager);
				
			}
			
		}catch(Throwable ex)
		{
			throw new ExceptionInInitializerError(ex);
		}
		return entityManager;
	}
	
	public static void closeEntityManager(String name)
	{
		EntityManager entityManager; 
		try {
			entityManager = entityHashMap.get(name);
			if(entityManager != null)
			{
				entityManager.close();
			}
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
}


