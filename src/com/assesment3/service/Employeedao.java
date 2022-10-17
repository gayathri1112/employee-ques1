package com.assesment3.service;

import java.util.ArrayList;

import com.assesment3.modelclass.Employee;



public interface Employeedao
{
  public ArrayList<Employee> displayEmployee(Employee employee);
  public void addEmployee(Employee employee);
  public void updateEmployee(Employee employee);
  public void deEmployee(Employee employee);
}