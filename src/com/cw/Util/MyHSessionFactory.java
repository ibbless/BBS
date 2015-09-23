package com.cw.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MyHSessionFactory {
		static SessionFactory sessionfactory = null;
		private  MyHSessionFactory(){
			
		}
		public static SessionFactory getSessionFactory(){
			if(sessionfactory==null){
				Configuration config = new Configuration().configure();
				ServiceRegistry regestry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				sessionfactory = config.buildSessionFactory(regestry);
				return sessionfactory;
			}
			else{
				return sessionfactory;
			}
		}
}
