package com.EmployeeManagementSystem.service;

import com.EmployeeManagementSystem.ExceptionalHandling.BadRequest;
import com.EmployeeManagementSystem.ExceptionalHandling.ResourceNotFoundException;
import com.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@Slf4j
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * GET ALL
     * @return
     */
    public List<Employee> findAllDetails(){
        List<Employee> Details = new ArrayList<>();
        employeeRepository.findAll().forEach(Details::add);
        Details.stream().findAny().orElseThrow(() ->{
            log.error("ResourceNotFound for "+Details);
            return new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Resource Not Found for"+Details);
        });
        log.info("Resource Found for "+Details);
        return Details;
    }

    /**
     * GET BY REQUEST PARAMETERS
     * @param empId
     * @return
     */
    public Employee findByEmpId(long empId){
        Employee employee = employeeRepository.findByEmpId(empId)
                .orElseThrow(() ->{
            log.error("ResourceNotFound for "+empId);
            return new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Resource Not Found for"+empId);
        });
        log.info("Resource Found for Employee Id: "+empId);
        return employee;
    }

    /**
     * GET BY REQUEST PARAMETERS
     * @param empName
     * @return
     */
    public List<Employee> findByEmpName(String empName){
        List<Employee> employee = employeeRepository.findByEmpName(empName).get();
                employee.stream().filter(p->p.getEmpName().equals(empName))
                        .findAny()
                        .orElseThrow(() ->{
                    log.error("ResourceNotFound for "+empName);
                    return new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Resource Not Found for"+empName);
                });
        log.info("Resource Found for Employee Name: "+empName);
        return employee;
    }

    /**
     * GET BY REQUEST PARAMETERS
     * @param location
     * @return
     */
    public List<Employee> findByLocation(String location){
        List<Employee> employee = employeeRepository.findByLocation(location).get();
        employee.stream().filter(p->p.getLocation().equals(location))
                .findAny()
                .orElseThrow(() ->{
                    log.error("ResourceNotFound for "+location);
                    return new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Resource Not Found for"+location);
                });
        log.info("Resource Found for Employee location: "+location);
        return employee;
    }

    /**
     * POST METHOD
     * @param employee
     * @return
     */
    public Object addDetails(Employee employee){
        ValidateEmployee validateEmployee = new ValidateEmployee();
        if(employee!=null){
            boolean result = validateEmployee.validateEmp(employee);
            try{
                if(result==true){
                    log.info("Details added for "+employee);
                    Employee emp = employeeRepository.save(employee);
                    return emp;
                }
                else{
                    log.error("Details not added for "+employee);
                    throw new BadRequest(HttpStatus.BAD_REQUEST,"Resource not Added for "+employee);
                }
            }
            catch (Exception e){
                log.info("Exception catched for "+employee);
                return e.getLocalizedMessage();
            }
        }
        return null;
    }

    /**
     * DELETE Method by Employee ID
     * @param id
     * @return
     */
    public Object deleteDetails(long id){
        Employee employee = employeeRepository.findByEmpId(id)
                .orElseThrow(() ->{
                    log.error("ResourceNotFound for "+id);
                    return new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Resource Not Found for"+id);
                });
        log.info("Deleted Details");
        employeeRepository.delete(employee);
        return ResponseEntity.ok();
    }

    /**
     * Update Method for whole Employee
     * @param id
     * @param emp
     * @return
     */
    public Employee updateDetails(long id,Employee emp){
        Employee employee = employeeRepository.findByEmpId(id)
                .orElseThrow(() ->{
                    log.error("ResourceNotFound for "+id);
                    return new ResourceNotFoundException(HttpStatus.NOT_FOUND,"Resource Not Found for"+id);
                });
        log.info("Employee found to be updated");
        employee.setKey(emp.getKey());
        employee.setEmpId(emp.getEmpId());
        employee.setEmpName(emp.getEmpName());
        employee.setLocation(emp.getLocation());
        employee.setDate(emp.getDate());
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    /**
     * Update Particular Name for Employee
     * @param id
     * @param name
     * @return
     */
    public Employee updateParticularName(long id,String name) {
        Employee employee = employeeRepository.findByEmpId(id)
                .orElseThrow(() -> {
                    log.error("ResourceNotFound for " + id);
                    return new ResourceNotFoundException(HttpStatus.NOT_FOUND, "Resource Not Found for" + id);
                });
        log.info("Employee Id found for Name to Updated.");
        employee.setEmpName(name);
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    /**
     * Update Particular Location for Employee
     * @param id
     * @param location
     * @return
     */
    public Employee updateParticularLocation(long id,String location) {
        Employee employee = employeeRepository.findByEmpId(id)
                .orElseThrow(() -> {
                    log.error("ResourceNotFound for " + id);
                    return new ResourceNotFoundException(HttpStatus.NOT_FOUND, "Resource Not Found for" + id);
                });
        log.info("Employee Id found for Location to Updated.");
        employee.setLocation(location);
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }



}
