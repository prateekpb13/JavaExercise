package com.brillio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class EmployeeRepository {

    Department department1=new Department(1,"IT",1991);
    Department department2=new Department(2,"Finance Department",1992);
    Department department3=new Department(3,"Operations Department",1993);
    Department department4=new Department(4,"Sales Department",1994);

    Employee employee1=new Employee(1001,"Prateek","Bavannavar","prateekpb13@gmail.com", "8721230999", LocalDate.of(2020, 11, 9),"CEO",30000d,null,null);
    Employee employee2=new Employee(1002,"Sachin","Tendulkar","sachin@gmail.com", "8721230901", LocalDate.of(1998, 4, 1),"CFO",29000d,1991,department1);
    Employee employee3=new Employee(1003,"Virat","Kohli","vk@gmail.com","8721990909", LocalDate.of(2013, 6, 18),"xyz",28000d,1991,department1);
    Employee employee4=new Employee(1004,"MS","Dhoni","msd@gmail.com","8767230902", LocalDate.of(2014, 7, 19),"abc",27000d,1992,department2);
    Employee employee5=new Employee(1005,"Rohit","Sharma","rs@gmail.com","8721230903", LocalDate.of(2015, 8, 20),"pqr",26000d,1992,department2);
    Employee employee6=new Employee(1006,"KL","Rahul","klr@gmail.com","8721230905", LocalDate.of(2015, 9, 21),"pqr",24000d,1992,department2);
    Employee employee7=new Employee(1007,"Jasprit","Bumrah","js@gmail.com","8721230904", LocalDate.of(2016, 9, 21),"efg",25000d,1993,department3);

    List<Employee> employees= Arrays.asList(employee1,employee2,employee3,employee4,employee5,employee6,employee7);

    public List<Employee> getEmployees() {
        return employees;
    }
}
