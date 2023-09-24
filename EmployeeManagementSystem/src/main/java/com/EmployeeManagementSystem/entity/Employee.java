package com.EmployeeManagementSystem.entity;

import com.EmployeeManagementSystem.CustomAnnotations.CustomS;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Employee_Details")
public class Employee implements Serializable {

    private static final long serialVersionUID = -4439114469417994311L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long key;

    @Column(name = "emp_Id")
    private long empId;

    @Column(name = "emp_Name")
    private String empName;

    @Column(name = "location")
    private String location;

    @CustomS(name="date",type = Date.class)
    private Date date;

    // Empty Constructor
    public Employee() {
        super();
    }

    // Constructor


    public Employee(long key, long empId, String empName, String location, Date date) {
        this.key = key;
        this.empId = empId;
        this.empName = empName;
        this.location = location;
        this.date = date;
    }

    // Getters and Setters
    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
