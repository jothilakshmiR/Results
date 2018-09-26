package com.program.Employee;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
      	
    	WorkName wn = new WorkName();
    	wn.setFname("priyaraman");
    	wn.setLname("priyanka");
    	wn.setMname("raman");
      Work program = new Work();
      program.setEmpId(003);
      program.setDepartment("admin");
      program.setSalary(20000);
      program.setJoinedOn(new Date());
      program.setWName(wn);
       Configuration con = new Configuration().configure().addAnnotatedClass(Work.class);
       
       ServiceRegistry reg =  new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
       SessionFactory sf = con.buildSessionFactory(reg);
       Session session =  sf.openSession();
       Transaction tx = session.beginTransaction();
       session.save(program);
       tx.commit();
       System.out.println(program); 
    }
    }

