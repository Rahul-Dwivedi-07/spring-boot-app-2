package com.RahulDwivedi.springbootapp.service;

import com.RahulDwivedi.springbootapp.model.Employee;

import java.util.List;

public interface EmployeeService {

    //implement this method in EmployeeServiceImpl
    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
