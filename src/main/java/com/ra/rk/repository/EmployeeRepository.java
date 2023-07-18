package com.ra.rk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ra.rk.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
