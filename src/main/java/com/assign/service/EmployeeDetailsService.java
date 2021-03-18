package com.assign.service;

import com.assign.entity.EmployeeDetails;

import java.util.List;

public interface EmployeeDetailsService {
    EmployeeDetails save(EmployeeDetails employeeDetails);
     List<EmployeeDetails> listEmployees();
     EmployeeDetails findEmployee(int id);
     void deleteEmployee(int id);
   void updateEmployee(EmployeeDetails employeeDetails);
   void updateEmployeeById(EmployeeDetails employeeDetails,int id);

}
