package com.fooddhaba.foodmarket.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateConfig 
{
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static
	{
		try
		{
			Configuration configuration = new Configuration().configure();
			
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch(HibernateException hbe)
		{
			System.out.println("Problem creating session factory!");
			hbe.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}
