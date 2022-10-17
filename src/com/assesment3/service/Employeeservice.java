package com.assesment3.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.assesment3.ConnectionFactory.ConnectionFactory;
import com.assesment3.modelclass.Employee;



public class Employeeservice implements Employeedao{



   private static final String A = null;
public ArrayList<Employee> displayEmployee(Employee employee)
    {
        ArrayList<Employee>arrayList=new ArrayList<Employee>();
        try {
        
        Connection con =ConnectionFactory.getConnection();
        Statement statement=con.createStatement();
        ResultSet  rset=statement.executeQuery("SELECT * FROM table2.table");
        while(rset.next()) {
          Employee emp=new Employee();
//          System.out.println(rset.getString(2));
          emp.setId(rset.getInt(1));
          emp.setName(rset.getString(2));
          emp.setSalary(rset.getDouble(3));
          arrayList.add(emp);
//          System.out.println(arrayList);
        }
        
    }catch(Exception e) {
        e.printStackTrace();
    }
        return arrayList;
    }



   public void addEmployee(Employee employee) {
//        ArrayList<Employee>arrayList=new ArrayList<Employee>();
        try {
            
            Connection con =ConnectionFactory.getConnection();
            Statement statement=con.createStatement();
            String query="insert into table2.table(`id`,`name`,`salary`) values('"+employee.getId()+"','"+employee.getName()+"','"+employee.getSalary() +"')";
            statement.executeUpdate(query);
            System.out.println("data inserted successfully");
            
        }catch(Exception e) {
            e.printStackTrace();
    }
    }
   public void deEmployee(Employee employee) {
        try {
        	
        Connection con =ConnectionFactory.getConnection();
        Statement statement=con.createStatement();
       String query="DELETE FROM table2.table WHERE (`id` ='"+employee.getId()+"' )";
               
       statement.executeUpdate(query);
        System.out.println("data deleted successfully");
        }catch(Exception e) {
            e.printStackTrace();
    }    
    }
   @Override
public void updateEmployee(Employee employee) {
	// TODO Auto-generated method stub
	 try {
         Connection con =ConnectionFactory.getConnection();
      Statement statement=con.createStatement();
      ResultSet  rset=statement.executeQuery("SELECT * FROM table2.table");
      Employee emp=new Employee();
      Scanner sc=new Scanner(System.in);
      System.out.println("enter the id to update salary");
      int s=sc.nextInt();
      if(s==emp.getId())
      {
          String query="insert into table2.table(`salary`)values ('"+employee.getSalary() +"')";
      
      statement.executeUpdate(query);
      }
      }catch(Exception e) {
          e.printStackTrace();
  }
	
}







   
}