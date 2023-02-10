//for each and every entity we must have repository as well

package com.RahulDwivedi.springbootapp.entity;

//this is an api
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//annotation for tablename which I need, I can define
//if we do not provide this, it will by default create table on the basis of class(EmployeeEntity) which we have provided
@Table(name = "tbl_employee")
public class EmployeeEntity {

    @Id
    private String employeeId;
    private String firstName;
    private String Lastname;
    private String emailId;
    private String department;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
