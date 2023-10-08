package annotationbysir.datasource;


import annotationbysir.entity.Departments;
import annotationbysir.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class
DataSource {


    public void storeDataInDatabase(Departments departments) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Departments.class);

        //create Session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(departments);
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void fetchData() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Departments.class);

        //create Session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        //fetch by using in build hibernate function in session object
        /*Departments departments = session.get(Departments.class, 1);
        System.out.println("Department Id:: " + departments.getDeptId());
        Employee employee = departments.getEmployee();
        System.out.println("Employee Name:: " + employee.getEmpName());
        System.out.println("Salary Details::  " + employee.getSalary());*/
        //hql
      /* String selectHql = "from Employee e where e.salary>500";
        Query query = session.createQuery(selectHql);
        Employee employee1 = (Employee) query.getSingleResult();
        System.out.println("Emp name:" + employee1.getEmpName());
        System.out.println("Emp Salary::" + employee1.getSalary());*/
        //criteria query
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        //create criteria query
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot);
        criteriaQuery.where(criteriaBuilder.greaterThan(employeeRoot.get("salary"), 500));
        Query query1 = session.createQuery(criteriaQuery);
        Employee employee2 = (Employee) query1.getSingleResult();
        System.out.println("emp_name:: " + employee2.getEmpName());
        System.out.println("salary info::" + employee2.getSalary());


    }
}

   /* public void updateDepartment(String departmentName, int departId) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Departments.class);

        //create Session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            //conventional way with in build function of hibernate session object
            Departments departments = session.get(Departments.class, departId);
            departments.setDepartName(departmentName);
            //Hql
            String updateHql = "update Departments set departName = :a where deptId = :b";
            Query query = session.createQuery(updateHql);
            query.setParameter("a", departmentName);
            query.setParameter("b", departId);
            int rowsupdate = query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }*/


