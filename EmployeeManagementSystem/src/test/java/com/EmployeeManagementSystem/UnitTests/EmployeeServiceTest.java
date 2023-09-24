//package com.EmployeeManagementSystem.EmployeeManagementSystem.UnitTests;
//
//import com.EmployeeManagementSystem.EmployeeManagementSystem.entity.Employee;
//import com.EmployeeManagementSystem.EmployeeManagementSystem.repository.EmployeeRepository;
//import com.EmployeeManagementSystem.EmployeeManagementSystem.service.EmployeeService;
//import org.junit.Test;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(classes = {EmployeeServiceTest.class})
//
//public class EmployeeServiceTest {
//
//    private static long empId = 2154906;
//    private static String empName = "Dhyeya";
//    private static String location = "Vadodara";
//
//    @Mock
//    EmployeeRepository employeeRepository;
//
//    @InjectMocks
//    EmployeeService employeeService;
//
//    @Test
//    @Order(1)
//    public void test_getAllDetails()
//    {
//        List<Employee> details = createEmployee();
//        Mockito.
//                when(employeeRepository.findAll()).
//                thenReturn(details);
//        assertEquals(employeeService.findAllDetails(),details);
//    }
//
//    @Test
//    @Order(2)
//    public void test_getByEmpName()
//    {
//        List<Employee> details = createEmployee();
//        Mockito.
//                when(employeeRepository.findByEmpName(empName).get()).
//                thenReturn(details);
//        assertEquals(employeeService.findByEmpName(empName).get(0),empName);
//    }
//
////    @Test
////    @Order(3)
////    public void test_getById()
////    {
////        Employee details = createEmployee1();
////        Mockito.
////                when(employeeRepository.findByEmpId(empId)).
////                thenReturn(details);
////        assertEquals(employeeService.findByEmpId(empId),empId);
////    }
//
////    @Test
////    @Order(1)
////    public void test_getAllDetails()
////    {
////        List<Employee> details = createEmployee();
////        Mockito.
////                when(employeeRepository.findAll()).
////                thenReturn(details);
////        assertEquals(employeeService.findAllDetails(),details);
////    }
//
//    public List<Employee> createEmployee(){
//        List<Employee> emp = new ArrayList<Employee>();
//        emp.add(new Employee(2154906, "Dhyeya", "Vadodara",));
//        emp.add(new Employee(2154907, "Malay", "Vadodara",));
//        emp.add(new Employee(2154908, "Prakhar", "Sagar",));
//        emp.add(new Employee(2154909, "Revant", "Ahmedabad",));
//        return emp;
//    }
//
//    public Employee createEmployee1(){
//        Employee employee = new Employee();
//        employee.setEmpId(2154906);
//        employee.setEmpName("Dhyeya");
//        employee.setLocation("Vadodara");
//        employee.setDate(2022-07-02T21:40:17.924592);
//        return employee;
//    }
//}
