package com.testing.sqlconnect.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll()
        .forEach(employees::add);
        return employees;
    }
    public Employee getOneEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee;
    }
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


}