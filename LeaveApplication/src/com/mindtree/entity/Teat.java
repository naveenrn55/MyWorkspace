package com.mindtree.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Teat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

	}

}
