package com.testing.sqlconnect.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(method = RequestMethod.POST, value="/employees")
    public void addEmployee(@RequestBody Employee employee){
        System.out.println("GHF");
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        System.out.println(employee.getPosition());
        System.out.println(employee.getSalary());
        employeeService.addEmployee(employee);
        // System.out.println("GHD");
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getOneEmployee(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/employees/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employeeService.updateEmployee(id, employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
    
}