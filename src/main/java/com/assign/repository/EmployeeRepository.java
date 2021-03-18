package com.assign.repository;

import com.assign.entity.EmployeeDetails;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeDetails,Integer> {
}
