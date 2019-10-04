package com.cjc.app.onetone;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

public class OneTest
{
	public static void main(String[] args) 
	{
		Session session= HibernateUtil.getSessionFactory().openSession();
		Employee emp= new Employee();
		emp.setName("vipin");
		emp.setEmail("vip.chauhan82@gmail.com");
		
		Address add=new Address();
		add.setAddressLine1("H.no-253/6,S no-17, warje pune");
		add.setCity("Pune");
		add.setState("Maharastra");
		add.setPincode(411058);
		add.setCountry("India");
		emp.setAddress(add);
		add.setEmployee(emp);
		
		Employee emp1= new Employee();
		emp1.setName("Laxmi");
		emp1.setEmail("lgjanp@gmail.com");
		
		Address add1=new Address();
		add1.setAddressLine1("H.no-253/6,S no-17, warje pune");
		add1.setCity("Varanasi");
		add1.setState("Uttar Pradesh");
		add1.setPincode(411058);
		add1.setCountry("India");
		emp1.setAddress(add1);
		add1.setEmployee(emp1);
		
		session.save(emp1);
		session.save(add1);
		session.save(emp);
		session.save(add);
		session.beginTransaction().commit();
		
		TypedQuery query=session.createQuery("from Employee");
		List<Employee> list=query.getResultList();   
        
	    Iterator<Employee> itr=list.iterator();    
	    while(itr.hasNext()){    
	     Employee em=itr.next();    
	     System.out.println(em.getEmployeeId()+" "+em.getName()+" "+em.getEmail());    
	     Address ad=emp.getAddress();    
	     System.out.println(ad.getAddressLine1()+" "+ad.getCity()+" "+    
	        ad.getState()+" "+ad.getCountry()+" "+ad.getPincode());    
	    }    
		
	}
}
