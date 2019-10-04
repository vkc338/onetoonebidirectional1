package com.cjc.app.onetone;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.MetadataSource;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	
	public static SessionFactory getSessionFactory()
	{
		Map<Object, String> settings= new HashMap<Object, String>();
		
		settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		settings.put(Environment.URL,"jdbc:mysql://localhost:3307/EmpDetails");
		settings.put(Environment.USER, "root");
		settings.put(Environment.PASS, "root");
		settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		settings.put(Environment.HBM2DDL_AUTO, "create");
		settings.put(Environment.SHOW_SQL, "true");
		
		registry= new StandardServiceRegistryBuilder().applySettings(settings).build();
		
		MetadataSources mds= new MetadataSources(registry).addAnnotatedClass(Employee.class).addAnnotatedClass(Address.class);
		
		Metadata md=mds.getMetadataBuilder().build();
		
		sessionFactory= md.getSessionFactoryBuilder().build();
		return sessionFactory;
	}
}
