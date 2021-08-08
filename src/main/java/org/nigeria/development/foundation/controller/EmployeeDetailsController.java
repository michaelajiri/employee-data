package org.nigeria.development.foundation.controller;

import org.nigeria.development.foundation.model.EmployeeDetails;
import org.nigeria.development.foundation.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee_biodata/employee_details")
@CrossOrigin
public class EmployeeDetailsController {

    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @GetMapping(value = "/allEmployeesDetails")
    public List<EmployeeDetails> getAllEmployeeDetails() {
        return employeeDetailsService.getAllEmployeeDetails();
    }

    @GetMapping(value = "/single_employee_details/{id}")
    public Optional<EmployeeDetails> getEmployeeDetailsById(@PathVariable(value = "id") Long id) {
        return employeeDetailsService.getEmployeeDetailsById(id);
    }

    @PostMapping(value = "/addEmployeeDetails")
    public EmployeeDetails addNewEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
        return employeeDetailsService.addNewEmployeeDetails(employeeDetails);
    }

    @PutMapping(value = "/editEmployeeDetails/{id}")
    public EmployeeDetails updateEmployeeDetails(@PathVariable(value = "id") Long id,
                                                 @RequestBody EmployeeDetails employeeDetails) {
        Optional<EmployeeDetails> employeeDetailsDb = employeeDetailsService.getEmployeeDetailsById(id);

        if (employeeDetailsDb.isPresent()) {
            employeeDetailsDb.get().setEmployee(employeeDetailsDb.get().getEmployee());
            employeeDetailsDb.get().setProfession(employeeDetailsDb.get().getProfession());
            employeeDetailsDb.get().setSalary(employeeDetailsDb.get().getSalary());
        }
        EmployeeDetails updatedEmployeeDetails = employeeDetailsService.addNewEmployeeDetails(employeeDetails);
        return updatedEmployeeDetails;
    }

    @DeleteMapping(value = "/deleteEmployeeDetails/{id}")
    public void removeEmployeeDetails(@PathVariable(value = "id") Long id) {
        employeeDetailsService.removeEmployeeDetails(id);
    }
}