package com.assesment3.controller;
import java.util.ArrayList;
import java.util.Scanner;

import com.assesment3.modelclass.Employee;
import com.assesment3.service.Employeeservice;
public class Employeeprovider {
    public  static  void addData() {
        Scanner sc=new Scanner(System.in);
        Employee employee=new Employee();
        System.out.println("enter the id,name and salary");
        employee.setId(sc.nextInt());
        employee.setName(sc.next());
        employee.setSalary(sc.nextDouble());
        Employeeservice employeeservice=new Employeeservice();
        employeeservice.addEmployee(employee);
        
    }
    public   static void displayData() {
        Employee employee=new Employee();
        Employeeservice employeeservice=new Employeeservice();
         ArrayList<Employee> l=employeeservice.displayEmployee(employee);
        for(Employee e :l) {
        	System.out.println(e.getId()+"\t");
            System.out.print(e.getName()+"\t");
            System.out.println(e.getSalary());
        }
    }
    public static void deleteData() {
        Scanner sc=new Scanner(System.in);
        Employee employee=new Employee();
        Employeeservice employeeservice=new Employeeservice();
        System.out.println("enter the id");
        int b=sc.nextInt();
        ArrayList<Employee> l=employeeservice.displayEmployee(employee);
 
        employeeservice.deEmployee(employee);
    }
    
public  static void updateData() {
    Scanner sc=new Scanner(System.in);
    Employee employee=new Employee();
    System.out.println("entyer id");
    System.out.println("enter the salary");
   employee.setSalary(sc.nextDouble());
    Employeeservice employeeservice=new Employeeservice();
    employeeservice.updateEmployee(employee);
    
    
}
    public static void Tester()//controller class
    {
        System.out.println("enter ur choice");
        System.out.println("1:add\n 2:display\n 3:update\n 0:delete");
        Scanner  scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        if(choice==1) {
            addData();
            Tester();
        }
        else if(choice==2) {
            displayData();
            System.out.println("enter 1 to do any operation /n 0 to exit");
            int d=scanner.nextInt();
            if(d==1)
            Tester();
            else
            	System.exit(d);
        }
        else if(choice==3) {
            updateData();
            System.out.println("enter 1 to do any operation /n 0 to exit");
            int d=scanner.nextInt();
            if(d==1)
            Tester();
            else
            	System.exit(d);
        }
        else if(choice==0) {
            deleteData();
            System.out.println("enter 1 to do any operation /n 0 to exit");
            int d=scanner.nextInt();
            if(d==1)
            Tester();
            else
            	System.exit(d);
        }
        else {
        	System.out.println("enter valid no:");
        	Tester();
        }
 }
    public static void main(String args[])
    {
    	Tester();
    }
}

