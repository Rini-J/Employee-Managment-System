package com.assign.controller;

import com.assign.entity.EmployeeDetails;
import com.assign.service.EmployeeDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Employee DEtails")
public class EmployeeController {
    @Autowired
    private EmployeeDetailsService employeeDetailsService;


    /* This method is for employee registration in employee management application.
     * It requests for name,age and salary.*/

    @ApiOperation(value = "Adding new ")
    @PostMapping("/employees")
    public void submitDetails(@RequestBody EmployeeDetails employeeDetails) {
        employeeDetailsService.save(employeeDetails);
    }

    /*
    This method is for retrieving employee details
    */
    @GetMapping
    public ResponseEntity<List<EmployeeDetails>> getAllEmployeeDetails() {
        List<EmployeeDetails> employeeDetailsList = employeeDetailsService.listEmployees();
        return new ResponseEntity<List<EmployeeDetails>>(employeeDetailsList, HttpStatus.OK);
    }

    /*
    This method is for retrieving specific employee details using id
    */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetails> getEmployeeDetails(@PathVariable("id") int id) {
        return new ResponseEntity<EmployeeDetails>(employeeDetailsService.findEmployee(id), HttpStatus.OK);
    }

    /*
    This method is for deleting employee details of the given id
    */
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeDetailsService.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    /*
    This method is for Updating employee details
    */
    @PutMapping("/employee")
    public String updateEmployee(@RequestBody EmployeeDetails employeeDetails) {
        employeeDetailsService.updateEmployee(employeeDetails);
        return "Updated";
    }

    /*
     This method is for updating employee details of the specified id
     */
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetails> updateEmployeeById(@PathVariable(value = "id") int id,
                                                              @RequestBody EmployeeDetails employeeDetails) {
        EmployeeDetails employee = employeeDetailsService.findEmployee(id);

        employee.setAge(employeeDetails.getAge());
        employee.setName(employeeDetails.getName());
        employee.setSalary(employeeDetails.getSalary());
        final EmployeeDetails updatedEmployee = employeeDetailsService.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

}
