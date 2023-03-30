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

        //store to DB
        dataSource.storeDataInDatabase(departments);
    }
}