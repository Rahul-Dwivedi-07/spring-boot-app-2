package com.RahulDwivedi.springbootapp.service;

import com.RahulDwivedi.springbootapp.exceptions.EmployeeNotFoundException;
import com.RahulDwivedi.springbootapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//EmplyeeServiceImpl is my service layer
@Service
//service is within annotated with component means this class has to used for bean creation
//all business logic here
//at controller layer we would need this object so that whatever business logic is defined in this layer, we could call those methods there via the EmployeeService interface
public class EmployeeServiceImpl implements EmployeeService{

    //as of now create a list to save all the employees
    //defined an empty arraylist here
    //whatever data comes here, try to store that data in employees list
    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        //do all business logic here
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            //generating random UUID here
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    //method for a particular URI that will give us all the records
    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    //get that particular object from employees list
    //id given as parameter at all the 3 places
    @Override
    public Employee getEmployeeById(String id) {
        //find first object from all the filtered objects
        return employees.stream().filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst().orElseThrow(() -> new EmployeeNotFoundException("Employee not found with Id: " + id));
    }

    /*
    Generally when we are building applications we would not use standard exceptions or runtime exceptions,
    we will create our own custom exceptions to handle them
    we will throw those custom exceptions from RunTimeExceptions and we will handle those exceptions in the rest APis
    */

    /*
    @Override
    public Employee getEmployeeById(String id) {
        //find first object from all the filtered objects
        return employees.stream().filter(employee -> employee.getEmployeeId().equals(id)).findFirst().get();
    }
    */

    /*
     @Override
    public Employee getEmployeeById(String id) {
        //find first object from all the filtered objects
        return employees.stream().filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Employee now found with Id: " + id));
    }
    */

    /*
    //for runtime exception
    @Override
    public Employee getEmployeeById(String id) {
        //find first object from all the filtered objects
        return employees.stream().filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Employee now found with Id: " + id));
    }
    */

    //implement delete method
    @Override
    public String deleteEmployeeById(String id){
        Employee employee = employees.stream().filter(e -> e.getEmployeeId().equalsIgnoreCase(id)).findFirst().get();
        employees.remove(employee);
        return "Employee deleted with the id: " + id;
    }
}
