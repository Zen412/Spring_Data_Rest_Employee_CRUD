package com.luv2code.springboot.demo.service;

import com.luv2code.springboot.demo.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    //
    List<Employee> findAll();
    Employee findById(int id);

    Employee save(Employee employee);
    void Delete(int id);

}
