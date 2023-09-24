package com.EmployeeManagementSystem.repository;

import com.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select emp from Employee emp where emp.empId=:empId")
    Optional<Employee> findByEmpId(long empId);

    @Query("select emp from Employee emp where emp.empName=:empName")
    Optional<List<Employee>> findByEmpName(String empName);

    @Query("select emp from Employee emp where emp.location=:location")
    Optional<List<Employee>> findByLocation(String location);

}
