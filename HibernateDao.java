package com.program.Employee;


	import java.util.Date;

	import java.util.List;
	 
	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import org.hibernate.mapping.Column;
	 
	
	 import com.program.Employee.WorkName;
	
	public class HibernateDao {
	    public List<Employee> getEmployeeList(){
	 
	        Session session = null;
	        List<Employee> empList = null;
	        try {
	            session = HibernateUtility.getSession();
	            String queryStr = "select emp from Employee emp";
	            Query query = session.createQuery(queryStr);
	            empList = query.list();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	        return empList;
	    }
	 
	    public Employee getEmployeeById(Long empId){
	 
	        Session session = null;
	        Employee emp = null;
	        try {
	            session =  HibernateUtility.getSession();
	            String queryStr = "select emp from Employee emp";
	            emp = (Employee) session.get(Employee.class, empId);
	 
	        } catch(Exception ex) {
	            ex.printStackTrace();
	         
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	        return emp;
	    }
	 
	    public void insertEmployee(Employee emp) {
	 
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtility.getSession();
	            transaction = session.beginTransaction();
	            session.save(emp);
	            System.out.println("inserted employee: "+emp.getName());
	            transaction.commit();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	          
	            if(transaction != null) transaction.rollback();
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	    }
	 
	    public void deleteEmployee(Employee emp) {
	 
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session =  HibernateUtility.getSession();
	            transaction = session.beginTransaction();
	            session.delete(emp);
	            transaction.commit();
	            System.out.println("deleted employee: "+emp.getName());
	        } catch(Exception ex) {
	            ex.printStackTrace();
	       
	            if(transaction != null) transaction.rollback();
	        } finally {
	            try {if(session != null) session.close();} catch(Exception ex) {}
	        }
	    }
	 
	    public static void main(String a[]) {
	 
	        Employee empDao = new Employee();
	 
	        Employee program = new Employee();
	        program.setName("Ajay");
	        program.setDepartment("Security");
	        program.setJoinedOn(new Date());
	        program.setSalary(10000);
	        empDao.insertEmployee(program);
	 
	        System.out.println("---------------------------");
	 
	        List<Employee> empList = empDao.getEmployeeList();
	        System.out.println("emp size: "+empList.size());
	        empList.stream().forEach(System.out::println);
	 
	        System.out.println("---------------------------");
	 
	        Employee emp = null;
			Employee empObj = empDao.getEmployeeById(emp.getEmpId());
	        System.out.println(empObj);
	 
	        System.out.println("---------------------------");
	        empDao.deleteEmployee(empObj);
	 
	        System.out.println("---------------------------");
	 
	        empList = empDao.getEmployeeList();
	        System.out.println("emp size: "+empList.size());
	        empList.stream().forEach(System.out::println);
	 
	        System.out.println("---------------------------");
	    }
	}


