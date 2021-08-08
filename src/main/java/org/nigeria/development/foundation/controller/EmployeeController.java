package org.nigeria.development.foundation.controller;

import org.nigeria.development.foundation.model.Employee;
import org.nigeria.development.foundation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee_biodata/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/allEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/single_employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping(value = "/addEmployee")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @PutMapping(value = "/editEmployee/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee employee) {
        Optional<Employee> employeeDb = employeeService.getEmployeeById(id);

        if (employeeDb.isPresent()) {
            employeeDb.get().setFirstName(employeeDb.get().getFirstName());
            employeeDb.get().setLastName(employeeDb.get().getLastName());
            employeeDb.get().setMiddleName(employeeDb.get().getMiddleName());
            employeeDb.get().setUsername(employeeDb.get().getUsername());
            employeeDb.get().setPassword(employeeDb.get().getPassword());
            employeeDb.get().setEmail(employeeDb.get().getEmail());
            employeeDb.get().setAddress(employeeDb.get().getAddress());
            employeeDb.get().setPhoneNumber(employeeDb.get().getPhoneNumber());
            employeeDb.get().setHeight(employeeDb.get().getHeight());
            employeeDb.get().setWeight(employeeDb.get().getWeight());
        }
        Employee updatedEmployee = employeeService.addNewEmployee(employee);
        return updatedEmployee;
    }

    @DeleteMapping(value = "/deleteEmployee/{id}")
    public void removeEmployee(@PathVariable(value = "id") Long id) {
        employeeService.removeEmployee(id);
    }
}