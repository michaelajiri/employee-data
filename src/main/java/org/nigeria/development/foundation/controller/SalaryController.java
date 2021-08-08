package org.nigeria.development.foundation.controller;

import org.nigeria.development.foundation.model.Salary;
import org.nigeria.development.foundation.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee_biodata/salary/")
@CrossOrigin
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @GetMapping(value = "/allSalaries")
    public List<Salary> getAllEmployees() {
        return salaryService.getAllSalaries();
    }

    @GetMapping(value = "/single_salary/{id}")
    public Optional<Salary> getSalaryById(@PathVariable(value = "id") Long id) {
        return salaryService.getSalaryById(id);
    }

    @PostMapping(value = "/addSalary")
    public Salary addNewSalary(@RequestBody Salary salary) {
        return salaryService.addNewSalary(salary);
    }

    @PutMapping(value = "/editSalary/{id}")
    public Salary updateSalary(@PathVariable(value = "id") Long id, @RequestBody Salary salary) {
        Optional<Salary> salaryDb = salaryService.getSalaryById(id);

        if (salaryDb.isPresent()) {
            salaryDb.get().setQualification(salaryDb.get().getQualification());
            salaryDb.get().setSalaryAmount(salaryDb.get().getSalaryAmount());
        }
        Salary updatedSalary = salaryService.addNewSalary(salary);
        return updatedSalary;
    }

    @DeleteMapping(value = "/deleteSalary/{id}")
    public void removeSalary(@PathVariable(value = "id") Long id) {
        salaryService.removeSalary(id);
    }
}