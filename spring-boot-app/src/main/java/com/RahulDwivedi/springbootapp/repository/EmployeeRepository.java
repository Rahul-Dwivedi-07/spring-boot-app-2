package com.RahulDwivedi.springbootapp.repository;

import com.RahulDwivedi.springbootapp.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//stereotype annotation
import org.springframework.stereotype.Repository;

//repository for all the functionalities and to store the data in the database
//entity that we want, type of Id in JpaRepository
//to tell spring that this is the repository that we have created we need to annotate it
@Repository
//by adding Repository it will be in spring's radar and whenever application starts it will be added in application context
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,String> {

}
