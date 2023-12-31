package com.shetech.employeemanager.service;
import com.shetech.employeemanager.repo.EmployeeRepo;
import com.shetech.employeemanager.model.Employee;
import com.shetech.employeemanager.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService (EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;

    }
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(randomUUID().toString());
        return employeeRepo.save(employee);
    }
public List<Employee> findAllEmployees(){
    return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()->new UserNotFoundException("User by id "+id+"was not found"));

    }
    public void deleteEmployee (Long id){
        employeeRepo.deleteEmployeeById(id);
    }


}
