package annotationbysir.main;


import annotationbysir.datasource.DataSource;
import annotationbysir.entity.Departments;
import annotationbysir.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ExecutionAnnotationMain {
    public static void main(String[] args) {
        Employee employee = new Employee();
        DataSource dataSource = new DataSource();
        Departments departments=new Departments();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter Emp Name");
        String empName = scanner.next();
        employee.setEmpName(empName);

        System.out.println("Enter emp Salary::");
        double salary = scanner.nextDouble();
        employee.setSalary(salary);



        System.out.println("Enter Department Name:");
        String deptName = scanner.next();
        departments.setDepartName(deptName);

        departments.setEmployee(employee);
        employee.setDepartments(departments);

        //store to DB
       // dataSource.storeDataInDatabase(departments);


        //fetch from db
       dataSource.fetchData();
       //update to db
       /* System.out.println("Please enter specific department to update ::");
        String dName = scanner.next();
        System.out.println("Please enter dept id for whom want to update ::");
        int departId = scanner.nextInt();
        dataSource.updateDepartment(dName, departId);*/
    }
}