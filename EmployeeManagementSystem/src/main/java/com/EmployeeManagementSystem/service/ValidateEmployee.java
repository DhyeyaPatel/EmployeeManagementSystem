package com.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.entity.Employee;

public class ValidateEmployee {

    public boolean validateEmp(Employee employee){

        long empId = employee.getEmpId();
        String id = Long.toString(empId);
        return id.length()<=6;
    }
}
