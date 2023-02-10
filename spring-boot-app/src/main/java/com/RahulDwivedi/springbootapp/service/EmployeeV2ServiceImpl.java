package com.RahulDwivedi.springbootapp.service;

import com.RahulDwivedi.springbootapp.entity.EmployeeEntity;
import com.RahulDwivedi.springbootapp.model.Employee;
import com.RahulDwivedi.springbootapp.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            //generating random UUID here
            employee.setEmployeeId(UUID.randomUUID().toString());
        }

        //Employee Repository is of the type Employee Entity not Employee
        //same field as employee is available in Employee Entity as well
        //create EmployeeEntity object
        EmployeeEntity entity = new EmployeeEntity();
        //all the values from Employee would be passed from employee to entity
        BeanUtils.copyProperties(employee,entity);
        employeeRepository.save(entity);

        //now employee and entity have the same data
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        //once we get list of employee entity we need to convert list of employee entity to employee and send it back
        //findAll method will return list of Employee Entity
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        //we can also use builder pattern or constructor argument to convert from one type to another
        //map to the employeeEntity
        //copy from employeeEntity to employee
        //collect and convert entire string to list
        //converting to employee list
        List<Employee> employees = employeeEntityList.stream().map(employeeEntity -> {Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity,employee);
            return employee;}).collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        //.get() to get the object because it will return optional argument of Java
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        //if object not available we can throw EmployeeNotFound Exception

       Employee employee = new Employee();
       BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee deleted with the id: " + id;
    }
}
