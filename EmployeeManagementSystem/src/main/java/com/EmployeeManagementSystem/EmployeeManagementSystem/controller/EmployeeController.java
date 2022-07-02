package com.EmployeeManagementSystem.EmployeeManagementSystem.controller;


import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Employee;
import com.EmployeeManagementSystem.EmployeeManagementSystem.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/empDetails")
@Component

/**
 * This class implements Error Controller interface to activate the logging feature. (But instead Slf4j is used in service)
 */
public class EmployeeController implements ErrorController {

    //private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /**
     * GET ALL
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody
    private ResponseEntity<List<Employee>> getAll() throws Exception{
        List<Employee> obj1 = employeeService.findAllDetails();
        return new ResponseEntity<>(obj1, HttpStatus.OK);
    }

    /**
     * GET by parameters(ID)
     * @param empId
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/byId")
    @ResponseBody
    private ResponseEntity<Employee> getByEmpId(@RequestParam(value = "id") long empId) throws Exception{

        Employee obj1 = employeeService.findByEmpId(empId);
        return new ResponseEntity<>(obj1, HttpStatus.OK);
    }

    /**
     * GET by parameters(Name)
     * @param empName
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/byName")
    @ResponseBody
    private ResponseEntity<List<Employee>> getByEmpName(@RequestParam(value = "name") String empName) throws Exception{

        List<Employee> obj1 = employeeService.findByEmpName(empName);
        return new ResponseEntity<>(obj1, HttpStatus.OK);
    }

    /**
     * GET by parameters(Location)
     * @param loc
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET, value = "/byLoc")
    @ResponseBody
    private ResponseEntity<List<Employee>> getByLoc(@RequestParam(value = "loc") String loc) throws Exception{

        List<Employee> obj1 = employeeService.findByLocation(loc);
        return new ResponseEntity<>(obj1, HttpStatus.OK);
    }

    /**
     * Add Details
     * @param employee
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/addDetails")
    public ResponseEntity<?> addDetails(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addDetails(employee),HttpStatus.CREATED);
    }

    /**
     * DELETE Details
     * @param empId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteDetails")
    public ResponseEntity<?> deleteDetails(@RequestParam (value ="id") long empId){
        return new ResponseEntity<>(employeeService.deleteDetails(empId),HttpStatus.OK);
    }

    /**
     * Update Employee Details
     * @param empId
     * @param employee
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/updateDetails")
    public ResponseEntity<?> updateDetails(@RequestParam (value ="id") long empId, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateDetails(empId,employee),HttpStatus.OK);
    }

    /**
     * Update Particular Employee Name Details
     * @param empId
     * @param empName
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/updatePatchName/{id}/{name}")
    public ResponseEntity<?> updateEmployeeNameDetails(@PathVariable(value="id")long empId,@PathVariable(value="name")String empName){
        return new ResponseEntity<>(employeeService.updateParticularName(empId,empName),HttpStatus.OK);
    }

    /**
     * Update Particular Employee Location Details
     * @param empId
     * @param location
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/updatePatchLoc/{location}")
    public ResponseEntity<?> updateEmployeeLocDetails(@RequestParam (value ="id") long empId, @PathVariable(value = ="loc")String location){
        return new ResponseEntity<>(employeeService.updateParticularLocation(empId,location),HttpStatus.OK);
    }

}
