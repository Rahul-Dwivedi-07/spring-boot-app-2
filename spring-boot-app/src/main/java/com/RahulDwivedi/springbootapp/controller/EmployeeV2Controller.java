package com.RahulDwivedi.springbootapp.controller;

import com.RahulDwivedi.springbootapp.model.Employee;
import com.RahulDwivedi.springbootapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//save all our data in database using V2
@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

    //with one interface we are able to have 2 different implementations with 2 different versions of api
    @Qualifier("employeeV2ServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    //this api would return data and not save unlike EmployeeController api
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

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
