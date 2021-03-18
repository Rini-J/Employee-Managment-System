package com.assign.service;

import com.assign.entity.EmployeeDetails;
import com.assign.repository.EmployeeRepository;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDetails save(EmployeeDetails employeeDetails) {
      return   employeeRepository.save(employeeDetails);
    }

    @Override
    public List<EmployeeDetails> listEmployees() {
        return (List<EmployeeDetails>) employeeRepository.findAll();
    }

    @Override
    public EmployeeDetails findEmployee(int id) {
        EmployeeDetails employeeDetails = employeeRepository.findById(id).get();
        return employeeDetails;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(EmployeeDetails employeeDetails) {
        employeeRepository.save(employeeDetails);
    }

    @Override
    public void updateEmployeeById(EmployeeDetails employeeDetail, int id) {
        List<EmployeeDetails> l = listEmployees();
        for (int i = 0; i < l.size(); i++) {
            EmployeeDetails e = l.get(i);
            if (e.getId() == id) {
                l.set(i, employeeDetail);
            }
        }
    }
}
