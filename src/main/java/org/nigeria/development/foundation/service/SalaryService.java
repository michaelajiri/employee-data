package org.nigeria.development.foundation.service;

import org.nigeria.development.foundation.model.Salary;
import org.nigeria.development.foundation.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    public List<Salary> getAllSalaries() {
        return (List<Salary>) salaryRepository.findAll();
    }

    public Optional<Salary> getSalaryById(Long id) {
        return salaryRepository.findById(id);
    }

    public Salary addNewSalary(Salary salary){
        return salaryRepository.save(salary);
    }

    public void updateSalary(Salary salary) {
        salaryRepository.save(salary);
    }

    public void removeSalary(Long id) {
        salaryRepository.deleteById(id);
    }
}