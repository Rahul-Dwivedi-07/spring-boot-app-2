package com.RahulDwivedi.springbootapp.controller;

import com.RahulDwivedi.springbootapp.model.Employee;
import com.RahulDwivedi.springbootapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.swing.border.EtchedBorder;
import java.util.List;

//for each and every mappping we provided the URI

//send response body back based on some of the requests
@RestController
//anything that comes up with /employee shall come to this controller
//defining base path here
//different methods different configuration we can define ahead
//v1 represents versoning - first version of api
@RequestMapping("/v1/employees")
public class EmployeeController {

    //require object of service here to perform any operations or call any methods of EmployeeService
    //qualifier to know which one we are using
    //for v1 we are using our business layer with employeeServiceImpl
    @Qualifier("employeeServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    //method for saving the employee in in-memory/database
    //taking entire employee object as the input
    //using RequestBody we will get entire RequestBody and all the fields over here
    //method would be called when we would be ding post http request for "/employees"
    @PostMapping
    //is we do ("/abc") above it will always call /employees/abc
    public Employee save(@RequestBody Employee employee){
        //call business layer or service layer to handle this employee
        //defined in interface and save method also
        return employeeService.save(employee);
    }

    //for this method no input parameter as we need all the data
    //will get record in browser in json format
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //id as a path variable
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    //create delete mapping
    //delete by id provided - provide path variable
    @DeleteMapping(value = "/{id}")
    public String deleteEmployeeById(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }

}
