package org.nigeria.development.foundation.repository;

import org.nigeria.development.foundation.model.Employee;
import org.nigeria.development.foundation.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}