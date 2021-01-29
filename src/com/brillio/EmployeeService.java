package com.brillio;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    public static void main( String[] args )
    {
        EmployeeRepository repository=new EmployeeRepository();
        List<Employee> employees=repository.getEmployees();

        //Find out the sum of salary of all employees.
        Double totalSalary=employees.stream().map(Employee::getSalary).reduce(0d,(a,b)->a+b);
        System.out.println("Total Salary: "+totalSalary);
        System.out.println();
        System.out.println();

        //List employee name and duration of their service in months and days
        System.out.println("Employee Name with duration of service");
        System.out.println();
        employees.forEach((a)->{
            System.out.print(a.getFirstName()+" "+a.getLastName()+": ");
            Period p = Period.between(a.getHireDate(), LocalDate.now());
            int totalMonths=p.getYears()*12+p.getMonths();
            System.out.println("Months: "+totalMonths+" ,Days: "+p.getDays());
        });
        System.out.println();
        System.out.println();

        //Find out employees without department
        List newEmployees=employees.stream().filter(a->a.getDepartment()==null).collect(Collectors.toList());
        System.out.println("Employees with no department: ");
        System.out.println();
        newEmployees.forEach(System.out::println);
        System.out.println();
        System.out.println();

        //Find out employees without employees
        Map<String,Integer> departEmpCount = new HashMap<String,Integer>(){{
            put("IT", 0);
            put("Finance Department", 0);
            put("Operations Department", 0);
            put("Sales Department", 0);
        }};
        employees.stream().forEach(a->{
            Optional dept= Optional.ofNullable(a.getDepartment());
            if (dept.isPresent()){
                String deptName= a.getDepartment().getDepartmentName();
                if (departEmpCount.containsKey(deptName)){
                    departEmpCount.put(deptName, departEmpCount.get(deptName)+1);
                }
            }
        });

        System.out.println("Department with no employee: ");
        System.out.println();
        for (Map.Entry<String, Integer> entry : departEmpCount.entrySet()) {
            if ((entry.getValue()).equals(0)) {
                System.out.println(entry.getKey());
            }
        }

        System.out.println();

        //Find departments with highest count of employees

        Map.Entry<String,Integer> max=null;
        for (Map.Entry<String, Integer> entry : departEmpCount.entrySet()) {
            if (max == null || max.getValue() < entry.getValue()) {
                max = entry;
            }
        }
        System.out.println("Department with highest employees: ");
        System.out.println();
        System.out.println(max.getKey());
        System.out.println();
        System.out.println();


        //        List out department names and count of employees in each department
        System.out.println("Department with Counts: ");
        System.out.println();
        for (Map.Entry<String, Integer> entry : departEmpCount.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        System.out.println();
        System.out.println();



        //List employee name,hire date and day of week on which employee has started

        System.out.println("Employee Details: ");
        System.out.println();
        employees.forEach(a->{
            System.out.print("Name: "+a.getFirstName()+" "+a.getLastName());
            System.out.print(" ,Hire date: "+a.getHireDate());
            System.out.println(" ,Day of week: "+a.getHireDate().getDayOfWeek());
        });
        System.out.println();
        System.out.println();

        // Sort Employees with EmployeeID
        System.out.println("Sorting by Employee Id:");
        List<Employee> employees1=employees.stream().sorted((a,b)->a.getEmployeeId()<b.getEmployeeId()?-1:1).collect(Collectors.toList());
        employees1.forEach(System.out::println);
        System.out.println();
        System.out.println();


        //Sort Employees with DepartmentID
        System.out.println("Sorting by Department Id:");
        List<Employee> employees2=employees.stream().sorted((a,b)->{
            Optional aDept=Optional.ofNullable(a.getDepartment());
            Optional bDept=Optional.ofNullable(b.getDepartment());
            if (aDept.isPresent()&&bDept.isPresent()){
                return a.getDepartment().getDepartmentId()<b.getDepartment().getDepartmentId()?-1:1;
            }
            return -1;
        }).collect(Collectors.toList());
        employees2.forEach(System.out::println);
        System.out.println();
        System.out.println();


        //Sort Employees with DepartmentID
        System.out.println("Sorting by FirstName:");
        List<Employee> employees3=employees.stream().sorted((a,b)->a.getFirstName().compareTo(b.getFirstName())>0?1:-1).collect(Collectors.toList());
        employees3.forEach(System.out::println);
        System.out.println();
        System.out.println();
    }
}
