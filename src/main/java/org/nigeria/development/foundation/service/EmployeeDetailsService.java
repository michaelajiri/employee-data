package org.nigeria.development.foundation.service;

import org.nigeria.development.foundation.model.EmployeeDetails;
import org.nigeria.development.foundation.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailsService {

    @Autowired
    EmployeeDetailsRepository employeeDetailsRepository;

    public List<EmployeeDetails> getAllEmployeeDetails() {
        return employeeDetailsRepository.findAll();
    }

    public Optional<EmployeeDetails> getEmployeeDetailsById(Long id) {
        return employeeDetailsRepository.findById(id);
    }

    public EmployeeDetails addNewEmployeeDetails(EmployeeDetails employeeDetails){
        return employeeDetailsRepository.save(employeeDetails);
    }

    public void updateEmployeeDetails(EmployeeDetails employeeDetails) {
        employeeDetailsRepository.save(employeeDetails);
    }

    public void removeEmployeeDetails(Long id) {
        employeeDetailsRepository.deleteById(id);
    }
}